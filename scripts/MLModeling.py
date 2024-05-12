import os
import math
from pprint import pprint
from pyspark.sql import SparkSession
import pyspark.sql.functions as F
from pyspark.ml import Pipeline, Transformer
from pyspark.ml.feature import VectorIndexer
from pyspark.ml.feature import StringIndexer, OneHotEncoder, VectorAssembler
from pyspark.ml.regression import LinearRegression
from pyspark.ml.regression import RandomForestRegressor
from pyspark.ml.tuning import ParamGridBuilder, CrossValidator
from pyspark.ml.evaluation import RegressionEvaluator

# Initializing spark connection
print("DEBUG: Initializing spark connection")

team = "team30"
warehouse = "project/hive/warehouse"

spark = SparkSession.builder\
        .appName("{} - spark ML".format(team))\
        .master("yarn")\
        .config("hive.metastore.uris",
                "thrift://hadoop-02.uni.innopolis.ru:9883")\
        .config("spark.sql.warehouse.dir", warehouse)\
        .config("spark.sql.avro.compression.codec", "snappy")\
        .enableHiveSupport()\
        .getOrCreate()

spark.sparkContext.setLogLevel("WARN")

rides = spark.read.format("avro").table("team30_projectdb.rides_part_buck")
rides.printSchema()

print("DEBUG: Spark connection initialized")

# Preprocessing


def run(command):
    return os.popen(command).read()


class TimeTransformer(Transformer):
    """
    This class takes a column in a unix time format
    and outputs several periodic variables in sine+cosine pairs.
    Here it is only limited to weekdays, hours, and minutes
    because our dataset only spans a single month
    """

    def __init__(self, inputCol, outputCols=["week_day_sin", "week_day_cos",
                                             "hour_sin", "hour_cos",
                                             "minute_sin", "minute_cos"]):
        super(TimeTransformer, self).__init__()
        self.inputCol = inputCol
        self.outputCols = outputCols

    def _transform(self, dataset):
        weekday = F.dayofweek(F.col(self.inputCol))
        weekday_sin = F.round(F.sin(2*math.pi*weekday/7), 14)
        weekday_cos = F.round(F.cos(2*math.pi*weekday/7), 14)

        hour = F.hour(F.col(self.inputCol))
        hour_sin = F.round(F.sin(2*math.pi*hour/7), 14)
        hour_cos = F.round(F.cos(2*math.pi*hour/7), 14)

        minute = F.minute(F.col(self.inputCol))
        minute_sin = F.round(F.sin(2*math.pi*minute/7), 14)
        minute_cos = F.round(F.cos(2*math.pi*minute/7), 14)

        return dataset.withColumn(self.outputCols[0], weekday_sin) \
                      .withColumn(self.outputCols[1], weekday_cos) \
                      .withColumn(self.outputCols[2], hour_sin) \
                      .withColumn(self.outputCols[3], hour_cos) \
                      .withColumn(self.outputCols[4], minute_sin) \
                      .withColumn(self.outputCols[5], minute_cos)


class CoordinatesTransformer(Transformer):
    """
    Transforms a pair of latitude&longitude columns
    into the ECEF format.
    In my case z is missing because it is always 0
    """

    def __init__(self, inputCol, outputCols):
        super(CoordinatesTransformer, self).__init__()
        self.lat = inputCol[0]
        self.lon = inputCol[1]
        self.outputCols = outputCols

    def _transform(self, dataset):
        a = 6378137
        e2 = 6.6943799901377997e-3
        n = a/F.sqrt(1 - e2*F.sin(self.lat)**2)

        x = n * F.cos(self.lat) * F.cos(self.lon)
        y = n * F.cos(self.lat) * F.sin(self.lon)

        return dataset.withColumn(self.outputCols[0], x) \
                      .withColumn(self.outputCols[1], y)


all_features = [
    "vendorid", "passenger_count", "trip_distance", "ratecodeid",
    "payment_type", "pickup_time", "pickup_longitude",
    "pickup_latitude", "dropoff_longitude", "dropoff_latitude"
]
LABEL = "fare_amount"

print("DEBUG: Selecting columns")
rides = rides.select(all_features + [LABEL]).na.drop()
rides = rides.withColumnRenamed(LABEL, "label")

rides.show(10)

cat_cols = ["vendorid", "ratecodeid" ,"payment_type"]
num_cols = ["passenger_count", "trip_distance"]
time_cols = ["week_day_sin", "week_day_cos",
             "hour_sin", "hour_cos",
             "minute_sin", "minute_cos",
             "pickup_x", "pickup_y", "dropoff_x", "dropoff_y"]

indexers = [
    StringIndexer(
        inputCol=c, outputCol="{0}_indexed".format(c)
    ).setHandleInvalid("skip")
    for c in cat_cols
]

encoders = [
    OneHotEncoder(
        inputCol=indexer.getOutputCol(),
        outputCol="{0}_encoded".format(indexer.getOutputCol())
    )
    for indexer in indexers
]

time_transformer = TimeTransformer(inputCol="pickup_time")
coordinates_transformer_1 = CoordinatesTransformer(
    inputCol=["pickup_latitude", "pickup_longitude"],
    outputCols=["pickup_x", "pickup_y"])
coordinates_transformer_2 = CoordinatesTransformer(
    inputCol=["dropoff_latitude", "dropoff_longitude"],
    outputCols=["dropoff_x", "dropoff_y"])

inputCols = [encoder.getOutputCol() for encoder in encoders] +\
            num_cols +\
            time_cols
assembler = VectorAssembler(inputCols=inputCols, outputCol="features",
                            handleInvalid="keep")

stages = indexers + encoders + [time_transformer] +\
         [coordinates_transformer_1, coordinates_transformer_2, assembler]
pipeline = Pipeline(stages=stages)

print("DEBUG: Fitting the pipeline")
model = pipeline.fit(rides)
print("DEBUG: Transforming the dataset")
data = model.transform(rides)
data = data.select(["features", "label"])
data.show(10)

print("DEBUG: Running VectorIndexer")
featureIndexer = VectorIndexer(inputCol="features", outputCol="indexedFeatures",
                               maxCategories=6).fit(data)
transformed = featureIndexer.transform(data)
transformed.show(10)

print("DEBUG: Splitting dataset")
train_data, test_data = transformed.randomSplit([0.7, 0.3])

print("DEBUG: Saving the dataset")
run("hdfs dfs -rm -R project/data")

train_data.select("indexedFeatures", "label")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("json")\
    .save("project/data/train")

# Run it from root directory of the repository
run("hdfs dfs -cat project/data/train/*.json > data/train.json")

test_data.select("indexedFeatures", "label")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("json")\
    .save("project/data/test")

# Run it from root directory of the repository
run("hdfs dfs -cat project/data/test/*.json > data/test.json")

print("DEBUG: Dataset preprocessed and saved!")

# MODELING

# Create evaluators
rmse_evaluator = RegressionEvaluator(labelCol="label",
                                     predictionCol="prediction",
                                     metricName="rmse")

r2_evaluator = RegressionEvaluator(labelCol="label",
                                   predictionCol="prediction",
                                   metricName="r2")

# Model 1 - linear regression

# Create Linear Regression Model
lr = LinearRegression(featuresCol="indexedFeatures")

# Fit the data to the pipeline stages
print("DEBUG: Fitting default Linear Regression")
model_lr = lr.fit(train_data)
predictions = model_lr.transform(test_data)
predictions.show(10)

rmse1 = rmse_evaluator.evaluate(predictions)
print("RMSE on test data, default Linear Regression = %g" % rmse1)
mae1 = r2_evaluator.evaluate(predictions)
print("R2 on test data, default Linear Regression = %g" % mae1)

lr_grid = ParamGridBuilder()
lr_grid = lr_grid.addGrid(model_lr.aggregationDepth, [2, 3])\
                 .addGrid(model_lr.regParam, [0.001, 0])\
                 .build()

cv = CrossValidator(estimator=lr,
                    estimatorParamMaps=lr_grid,
                    evaluator=rmse_evaluator,
                    parallelism=5,
                    numFolds=3)

print("DEBUG: Running grid search...")
cvModel = cv.fit(train_data)
model1 = cvModel.bestModel
pprint(model1.extractParamMap())

print("DEBUG: Saving the model")
model1.write().overwrite().save("project/models/model1")
run("hdfs dfs -get project/models/model1 models/model1")

print("DEBUG: Making and saving predictions")
predictions = model1.transform(test_data)
predictions.show(10)

predictions.select("label", "prediction")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header", "true")\
    .save("project/output/model1_predictions.csv")

# I'm doing this because the string is too long otherwise
CSV_NAME = "model1_predictions.csv"
run("hdfs dfs -cat project/output/{0}/*.csv > output/{0}".format(CSV_NAME))

print("DEBUG: Evaluating performance")
rmse1 = rmse_evaluator.evaluate(predictions)
print("RMSE on test data, best Linear Regression model = %g" % rmse1)
mae1 = r2_evaluator.evaluate(predictions)
print("R2 on test data, best Linear Regression model = %g" % mae1)

# model 2 - random forest regressor

# Create Logistic Regression Model
rfr = RandomForestRegressor(featuresCol="indexedFeatures")

# Fit the data to the pipeline stages
print("DEBUG: Fitting default Random Forest Regressor")
model_rfr = rfr.fit(train_data)
predictions = model_rfr.transform(test_data)
predictions.show(10)

rmse2 = rmse_evaluator.evaluate(predictions)
print("RMSE on test data, default Random Forest Regressor = %g" % rmse2)
mae2 = r2_evaluator.evaluate(predictions)
print("R2 on test data, default Random Forest Regressor = %g" % mae2)

rfr_grid = ParamGridBuilder()
rfr_grid = rfr_grid.addGrid(model_rfr.maxDepth, [5, 6])\
                   .addGrid(model_rfr.maxBins, [32, 64])\
                   .build()

cv = CrossValidator(estimator=rfr,
                    estimatorParamMaps=rfr_grid,
                    evaluator=rmse_evaluator,
                    parallelism=5,
                    numFolds=3)

print("DEBUG: Running grid search...")
cvModel = cv.fit(train_data)
model2 = cvModel.bestModel
pprint(model2.extractParamMap())

print("DEBUG: Saving the model")
model2.write().overwrite().save("project/models/model2")
run("hdfs dfs -get project/models/model2 models/model2")

print("DEBUG: Making and saving predictions")
predictions = model2.transform(test_data)
predictions.show(10)

predictions.select("label", "prediction")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header", "true")\
    .save("project/output/model2_predictions.csv")

# I'm doing this because the string is too long otherwise
CSV_NAME = "model2_predictions.csv"
run("hdfs dfs -cat project/output/{0}/*.csv > output/{0}".format(CSV_NAME))

print("DEBUG: Evaluating performance")
rmse2 = rmse_evaluator.evaluate(predictions)
print("RMSE on test data, best Random Forest Regressor model = %g" % rmse2)
mae2 = r2_evaluator.evaluate(predictions)
print("R2 on test data, best Random Forest Regressor model = %g" % mae2)

# Compare the best models & save the results

# Create data frame to report performance of the models
print("DEBUG: Saving the model comparison table")
models = [[str(model1), rmse1, mae1], [str(model2), rmse2, mae2]]

df = spark.createDataFrame(models, ["model", "RMSE", "R2"])
df.show(truncate=False)

# Save it to HDFS
df.coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header", "true")\
    .save("project/output/evaluation.csv")

# Run it from root directory of the repository
run("hdfs dfs -cat project/output/evaluation.csv/*.csv > output/evaluation.csv")

print("DEBUG: ML Modeling is done")

-- using our dataset
USE team30_projectdb;


-- create Hive Table 1
DROP TABLE IF EXISTS model1_predictitons;

CREATE TABLE model1_predictitons(
label DOUBLE,
prediction DOUBLE)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
STORED AS TEXTFILE
location 'project/output/model1_predictions.csv';


-- create Hive Table 2
DROP TABLE IF EXISTS model2_predictitons;

CREATE TABLE model2_predictitons(
label DOUBLE,
prediction DOUBLE)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
STORED AS TEXTFILE
location 'project/output/model2_predictions.csv';

-- create Hive Table 3
DROP TABLE IF EXISTS evaluation;

CREATE TABLE evaluation(
model VARCHAR(50),
RMSE DOUBLE,
R2 DOUBLE)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
STORED AS TEXTFILE
location 'project/output/evaluation.csv';



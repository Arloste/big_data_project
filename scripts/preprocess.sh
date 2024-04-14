# installing kaggle package & downloading dataset from kaggle
echo "LOGGER: Started downloading dataset"
pip install --user kaggle > /dev/null

user_name="elemento"
dataset_name="nyc-yellow-taxi-trip-data"

rm -R data
kaggle datasets download $user_name/$dataset_name
unzip $dataset_name.zip 'yellow_tripdata_2015-01.csv' -d data/
rm $dataset_name.zip

echo "LOGGER: Dataset downloaded"


# the downloaded dataset contains error and has to be preprocessed
echo "LOGGER: Preprocessing the dataset"
python3 scripts/preprocess_dataset.py
echo "LOGGER: Dataset preprocessed"

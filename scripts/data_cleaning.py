"""
Module to preprocess a CSV dataset by filling missing values
 in the 'improvement_surcharge' column with 0 and remove outliers, which
 include negatie and extremely large total_amount.

Attributes:
    DATASET_PATH (str): Path to the CSV dataset file.

Dependencies:
    - dask[dataframe]
    - pandas
"""

import os
import dask.dataframe as dd
import pandas as pd
from tqdm import tqdm

CHUNK_SIZE = 50000
DATASET_PATH = "data/yellow_tripdata_2015-01.csv"
print("DEBUG: Starting cleaning the dataset")
df = dd.read_csv(DATASET_PATH, blocksize=25e6)
print(len(df))
df = df[(df.total_amount > 3.3) &
        (df.total_amount < 100.947)]
print("DEBUG: Removed outliers")
df.improvement_surcharge = df.improvement_surcharge.fillna(0)
print("DEBUG: Filled missing values")
df.to_csv(DATASET_PATH[:-4] + "/", index=False)
print("DEBUG: Saved clean dataset parts")

del df

# Thank to https://stackoverflow.com/questions/17444679/reading-a-huge-csv-file

csv_file_list = os.listdir(DATASET_PATH[:-4] + "/")
OUTPUT_FILE = DATASET_PATH[:-4] + "_preprocessed.csv"

FIRST_ONE = True
for csv_file_name in tqdm(csv_file_list):
    if not FIRST_ONE:
        skip_row = [0]
    else:
        skip_row = []
    csv_path = DATASET_PATH[:-4] + "/" + csv_file_name
    chunk_container = pd.read_csv(csv_path, chunksize=CHUNK_SIZE, skiprows=skip_row)
    for chunk in chunk_container:
        if FIRST_ONE:
            chunk.to_csv(OUTPUT_FILE, mode="w", index=False, header=True)
            FIRST_ONE = False
        else:
            chunk.to_csv(OUTPUT_FILE, mode="a", index=False, header=False)
print("DEBUG: Merged clean dataset")

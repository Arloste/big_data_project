"""
Module to preprocess a CSV dataset by filling missing values
 in the 'improvement_surcharge' column with 0.

Attributes:
    DATASET_PATH (str): Path to the CSV dataset file.

Dependencies:
    - pandas (imported as pd)
"""

import pandas as pd

DATASET_PATH = "data/yellow_tripdata_2015-01.csv"
df = pd.read_csv(DATASET_PATH)
df.improvement_surcharge = df.improvement_surcharge.fillna(0)
df.to_csv(DATASET_PATH, index=False)
print("DEBUG: Filled missing values")

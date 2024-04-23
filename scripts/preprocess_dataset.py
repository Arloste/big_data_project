"""
Module to preprocess a CSV dataset by filling missing values
 in the 'improvement_surcharge' column with 0.

Attributes:
    DATASET_PATH (str): Path to the CSV dataset file.

Dependencies:
    - pandas (imported as pd)
"""

import pandas as pd
import numpy as np

DATASET_PATH = "data/yellow_tripdata_2015-01.csv"
df = pd.read_csv(DATASET_PATH)
# df = df[(df.total_amount > np.percentile(df.total_amount.to_numpy(), 0.1)) &
#         (df.total_amount < np.percentile(df.total_amount.to_numpy(), 99.9))]
df.improvement_surcharge = df.improvement_surcharge.fillna(0)
df.to_csv(DATASET_PATH, index=False)
print("DEBUG: Filled missing values")

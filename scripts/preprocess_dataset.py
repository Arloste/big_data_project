import pandas as pd

dataset_path = "data/yellow_tripdata_2015-01.csv"
df = pd.read_csv(dataset_path)
df.improvement_surcharge = df.improvement_surcharge.fillna(0)
df.to_csv(dataset_path, index=False)

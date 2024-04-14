#!/bin/bash

# Preparation -- moving schemas to warehouse/avsc
echo "LOGGER: Moving schemas to warehouse/avsc"
password="GEEzBg4UuiWuNj0T"

# Remove existing folder
hdfs dfs -rm -R project/warehouse/avsc

# Create folder for schema
hdfs dfs -mkdir -p project/warehouse/avsc

# Move schema to folder
hdfs dfs -put output/rides.avsc project/warehouse/avsc/

echo "LOGGER: Schemas moved"


# Build Hive Tables
echo "LOGGER: Building Hive Tables"
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n teamx30 -p $password -f sql/db.hql > output/hive_results.txt
echo "LOGGER: Build tables; see output in output/hive_results.txt"


# Performs EDA
echo "LOGGER: EDA [1/5]..."
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team30 -p $password -f sql/q1.hql
echo "LOGGER: EDA -- ALL DONE"

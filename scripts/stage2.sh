#!/bin/bash

# Preparation -- moving schemas to warehouse/avsc
# echo "LOGGER: Moving schemas to warehouse/avsc"
password="GEEzBg4UuiWuNj0T"

# Remove existing folder
# hdfs dfs -rm -R project/warehouse/avsc

# Create folder for schema
# hdfs dfs -mkdir -p project/warehouse/avsc

# Move schema to folder
# hdfs dfs -put output/rides.avsc project/warehouse/avsc/

# echo "LOGGER: Schemas moved"


# Build Hive Tables
# echo "LOGGER: Building Hive Tables"
# beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team30 -p $password -f sql/db.hql > output/hive_results.txt 2> /dev/null
# echo "LOGGER: Build tables; see output in output/hive_results.txt"


# Performs EDA
echo "LOGGER: EDA [1/5]..."
# runs the command
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team30 -p $password -f sql/q1.hql >> output/hive_results.txt 2> /dev/null
# put the headers of the resulting table into your csv file
echo "vendorid,total_sum" > output/q1.csv
# put the rest of the table into your csv file
hdfs dfs -cat project/output/q1/* >> output/q1.csv

echo "LOGGER: EDA [2/5]..."





# echo "LOGGER: EDA -- ALL DONE"

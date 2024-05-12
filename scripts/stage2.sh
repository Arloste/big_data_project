#!/bin/bash

# Preparation -- moving schemas to warehouse/avsc
echo "LOGGER: Moving schemas to warehouse/avsc"
password="GEEzBg4UuiWuNj0T"

# Remove existing folder
hdfs dfs -rm -R project/warehouse/avsc

# Clear the trash
hdfs dfs -rm -r .Trash

# Create folder for schema
hdfs dfs -mkdir -p project/warehouse/avsc

# Move schema to folder
hdfs dfs -put output/rides.avsc project/warehouse/avsc/

echo "LOGGER: Schemas moved"


# Build Hive Tables
echo "LOGGER: Building Hive Tables"

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team30 -p $password -f sql/db.hql >> output/hive_results.txt 2> /dev/null
echo "LOGGER: Created external table [1/3]"

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team30 -p $password -f sql/create_partition.hql >> output/hive_results.txt 2> /dev/null
echo "LOGGER: Created partition [2/3]"

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team30 -p $password -f sql/create_bucketing.hql >> output/hive_results.txt 2> /dev/null
echo "LOGGER: Created buckets [3/3]"

echo "LOGGER: Built tables; see output in output/hive_results.txt"


# Performs EDA
echo "LOGGER: EDA [1/5]..."
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team30 -p $password -f sql/q1.hql >> output/hive_results.txt 2> /dev/null
echo "pickup_time,num_rides" > output/q1.csv
hdfs dfs -cat project/output/q1/* >> output/q1.csv

echo "LOGGER: EDA [2/5]..."
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team30 -p $password -f sql/q2.hql >> output/hive_results.txt 2> /dev/null
echo "day,vendor_1_rides,vendor_2_rides" > output/q2.csv
hdfs dfs -cat project/output/q2/* >> output/q2.csv

echo "LOGGER: EDA [3/5]..."
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team30 -p $password -f sql/q3.hql >> output/hive_results.txt 2> /dev/null
echo "ride_duration_minutes,vendor_1_tips,vendor_2_tips" > output/q3.csv
hdfs dfs -cat project/output/q3/* >> output/q3.csv

echo "LOGGER: EDA [4/5]..."
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team30 -p $password -f sql/q4.hql >> output/hive_results.txt 2> /dev/null
echo "day,vendor_1_faulty_rides,vendor_2_faulty_rides" > output/q4.csv
hdfs dfs -cat project/output/q4/* >> output/q4.csv

echo "LOGGER: EDA [5/5]..."
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team30 -p $password -f sql/q5.hql >> output/hive_results.txt 2> /dev/null
echo "latitude,longitude,avg_ride_cost" > output/q5.csv
hdfs dfs -cat project/output/q5/* >> output/q5.csv

echo "LOGGER: EDA -- ALL DONE"
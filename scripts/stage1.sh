# reads the dataset into postresql
echo "LOGGER: Building the project"
python3 scripts/build_projectdb.py
echo "LOGGER: Project is built"


# imports the database into HDFS via Sqoop
echo "LOGGER: Importing dataset to HDFS"
password="GEEzBg4UuiWuNj0T"

# removes everything from the warehouse
hdfs dfs -rm -R project/warehouse/*

# import all tables
sqoop import-all-tables --connect jdbc:postgresql://hadoop-04.uni.innopolis.ru/team30_projectdb --username team30 --password $password --compression-codec=snappy --compress --as-avrodatafile --warehouse-dir=project/warehouse --m 1

# moving rides.avsc and rides.java to output/
mv rides.avsc output/
mv rides.java output/

echo "LOGGER: Dataset is imported"

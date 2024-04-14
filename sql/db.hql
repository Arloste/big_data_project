DROP DATABASE IF EXISTS team30_projectdb;

CREATE DATABASE team30_projectdb LOCATION "project/hive/warehouse";

CREATE EXTERNAL TABLE rides STORED AS AVRO LOCATION 'project/warehouse/rides' TBLPROPERTIES ('avro.schema.url'='project/warehouse/avsc/rides.avsc');

SELECT * FROM rides LIMIT 5;

-- using our dataset
USE team30_projectdb;


-- create Hive Table 2
DROP TABLE IF EXISTS q3_results;

CREATE TABLE q3_results(
ride_length_minutes INTEGER,
vendor_1_tips DECIMAL,
vendor_2_tips DECIMAL)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q3';


-- run query & save results in table 

SET hive.resultset.use.unique.column.names = false;

INSERT INTO q3_results
SELECT p.ride_length,
       SUM(CASE WHEN p.vendorid = 1 THEN p.tip_amount ELSE 0 END) AS vendor_1_tips,
       SUM(CASE WHEN p.vendorid = 2 THEN p.tip_amount ELSE 0 END) AS vendor_2_tips
FROM (
       SELECT HOUR(dropoff_time - pickup_time)*60 + MINUTE(dropoff_time - pickup_time) AS ride_length, tip_amount, vendorid
       FROM rides_part_buck
) AS p
GROUP BY p.ride_length
HAVING p.ride_length > -1
ORDER BY p.ride_length;


-- save table to hdfs

INSERT OVERWRITE DIRECTORY 'project/output/q3'
ROW FORMAT DELIMITED FIELDS
TERMINATED BY ','
SELECT * FROM q3_results;
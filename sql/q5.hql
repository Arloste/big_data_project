-- using our dataset
USE team30_projectdb;


-- create Hive Table 2
DROP TABLE IF EXISTS q5_results;

CREATE TABLE q5_results(
latitude DOUBLE,
longitude DOUBLE,
avg_ride_cost DOUBLE)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q5';


-- run query & save results in table 

SET hive.resultset.use.unique.column.names = false;

INSERT INTO q5_results
SELECT p.lat, p.lon, AVG(p.total_amount) AS total
FROM (
   SELECT ROUND(pickup_latitude, 3) AS lat, ROUND(pickup_longitude, 3) AS lon, total_amount FROM rides_part_buck
   WHERE pickup_longitude > -80 AND pickup_longitude < -70 AND pickup_latitude > 35 AND pickup_latitude < 50
) AS p
GROUP BY p.lat, p.lon
ORDER BY total DESC;

-- save table to hdfs

INSERT OVERWRITE DIRECTORY 'project/output/q5'
ROW FORMAT DELIMITED FIELDS
TERMINATED BY ','
SELECT * FROM q5_results;
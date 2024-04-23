-- using our dataset
USE team30_projectdb;


-- create Hive Table 2
DROP TABLE IF EXISTS q2_results;

CREATE TABLE q2_results(
day VARCHAR(5),
vendor_1_rides INTEGER,
vendor_2_rides INTEGER)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q2';


-- run query & save results in table 

SET hive.resultset.use.unique.column.names = false;

INSERT INTO q2_results
SELECT p.day,
       SUM(CASE WHEN p.vendorid = 1 THEN 1 ELSE 0 END) AS vendor_1_count,
       SUM(CASE WHEN p.vendorid = 2 THEN 1 ELSE 0 END) AS vendor_2_count
FROM (
       SELECT LPAD(CAST(DAY(pickup_time) AS VARCHAR(2)), 2, '0') || '-' || LPAD(CAST(MONTH(pickup_time) AS VARCHAR(2)), 2, '0') AS day, vendorid
       FROM rides_part_buck
) AS p
GROUP BY p.day
ORDER BY p.day;


-- save table to hdfs

INSERT OVERWRITE DIRECTORY 'project/output/q2'
ROW FORMAT DELIMITED FIELDS
TERMINATED BY ','
SELECT * FROM q2_results;
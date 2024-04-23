-- using our dataset
USE team30_projectdb;


-- create Hive Table 1
DROP TABLE IF EXISTS q1_results;

CREATE TABLE q1_results(
hour_minute VARCHAR(5),
n_rides INTEGER)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q1';


-- run query & save results in table 

SET hive.resultset.use.unique.column.names = false;
INSERT INTO q1_results
SELECT p.pickup_time, COUNT(*)
FROM (
    SELECT LPAD(CAST(HOUR(pickup_time) AS VARCHAR(2)), 2, '0') || ':' || LPAD(CAST(MINUTE(pickup_time) AS VARCHAR(2)), 2, '0') AS pickup_time
    FROM rides_part_buck
) as p
GROUP BY p.pickup_time
ORDER BY p.pickup_time;


-- save table to hdfs

INSERT OVERWRITE DIRECTORY 'project/output/q1' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q1_results;

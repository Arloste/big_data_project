-- using our dataset
USE team30_projectdb;


-- create Hive Table 2
DROP TABLE IF EXISTS q4_results;

CREATE TABLE q4_results(
day VARCHAR(5),
vendor_1_faulty_trips INTEGER,
vendor_2_faulty_trips INTEGER)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q4';


-- run query & save results in table 

SET hive.resultset.use.unique.column.names = false;

INSERT INTO q4_results
SELECT p.day,
       SUM(CASE WHEN p.vendorid = 1 AND p.payment_type > 2 THEN 1 ELSE 0 END) AS vendor_1_faulty_rides,
       SUM(CASE WHEN p.vendorid = 2 AND p.payment_type > 2 THEN 1 ELSE 0 END) AS vendor_2_faulty_rides
FROM (
    SELECT LPAD(CAST(DAY(pickup_time) AS VARCHAR(2)), 2, '0') || '-' || LPAD(CAST(MONTH(pickup_time) AS VARCHAR(2)), 2, '0') AS day, vendorid, payment_type
    FROM rides_part_buck
) AS p
GROUP BY p.day
ORDER BY p.day;

-- save table to hdfs

INSERT OVERWRITE DIRECTORY 'project/output/q4'
ROW FORMAT DELIMITED FIELDS
TERMINATED BY ','
SELECT * FROM q4_results;
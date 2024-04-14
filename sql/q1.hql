-- using our dataset
USE team30_projectdb;


-- create Hive Table 1
DROP TABLE IF EXISTS q1_results;

CREATE TABLE q1_results(
vendorId SMALLINT,
total_amount DECIMAL)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q1';


-- run query & save results in table 

SET hive.resultset.use.unique.column.names = false;

INSERT INTO q1_results
SELECT p.vendorid as vendorid, SUM(p.total_amount) as total_sum
FROM (
    SELECT * FROM rides LIMIT 100
) as p
GROUP BY p.vendorid;


-- save table to hdfs

INSERT OVERWRITE DIRECTORY 'project/output/q1' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q1_results;

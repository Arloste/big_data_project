-- query 1

SELECT vendorid, SUM(total_amount) FROM rides GROUP BY vendorid;


-- create Hive Table 1

USE team30_projectdb;

DROP TABLE IF EXISTS q1_results;

CREATE EXTERNAL TABLE q1_results(
	vendorId	SMALLINT;
	total_amount	DECIMAL;
)

ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q1'


-- save results in table 

USE team30_projectdb;

SET hive.resultset.use.unique.column.names = false;

INSERT INTO q1_results
SELECT vendorid, SUM(total_amount) FROM rides;
SELECT * FROM q1_results; 

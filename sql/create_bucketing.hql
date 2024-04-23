USE team30_projectdb;

DROP TABLE IF EXISTS rides_part_buck;

SET hive.exec.dynamic.partition=true;
SET hive.exec.dynamic.partition.mode=nonstrict;

CREATE EXTERNAL TABLE rides_part_buck(
	vendorID		SMALLINT,
	pickup_time		TIMESTAMP,
	dropoff_time		TIMESTAMP,
	passenger_count		INTEGER,
	trip_distance		DOUBLE,
	pickup_longitude	DOUBLE,
	pickup_latitude		DOUBLE,
	rateCodeId		SMALLINT,
	store_and_fwd_flag	VARCHAR(1),
	dropoff_longitude	DOUBLE,
	dropoff_latitude	DOUBLE,
	fare_amount		DOUBLE,
	extra			DOUBLE,
	mta_tax			DOUBLE,
	improvement_surcharge	DOUBLE,
	tip_amount		DOUBLE,
	tolls_amount		DOUBLE,
	total_amount		DOUBLE)
PARTITIONED BY (payment_type SMALLINT)
CLUSTERED BY (tip_amount) into 7 buckets
STORED AS AVRO LOCATION 'project/hive/warehouse/rides_part_buck'
TBLPROPERTIES ('AVRO.COMPRESS'='SNAPPY');

INSERT INTO rides_part_buck
SELECT vendorID, pickup_time, dropoff_time, passenger_count, trip_distance, pickup_longitude, pickup_latitude, rateCodeId, store_and_fwd_flag,
dropoff_longitude, dropoff_latitude, fare_amount, extra, mta_tax, improvement_surcharge, tip_amount, tolls_amount, total_amount, payment_type
FROM rides;

SELECT * FROM rides_part WHERE tip_amount > 5 LIMIT 5;
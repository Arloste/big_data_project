USE team30_projectdb;

DROP TABLE IF EXISTS rides_part;

SET hive.exec.dynamic.partition=true;
SET hive.exec.dynamic.partition.mode=nonstrict;

CREATE EXTERNAL TABLE rides_part(
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
PARTITIONED BY (vendorID SMALLINT,
                payment_type SMALLINT)
STORED AS AVRO LOCATION 'project/hive/warehouse/rides_part'
TBLPROPERTIES ('AVRO.COMPRESS'='SNAPPY');

INSERT overwrite TABLE rides_part
PARTITION (vendorID, payment_type)
SELECT pickup_time, dropoff_time, passenger_count, trip_distance, pickup_longitude, pickup_latitude, rateCodeId, store_and_fwd_flag,
dropoff_longitude, dropoff_latitude, fare_amount, extra, mta_tax, improvement_surcharge, tip_amount, tolls_amount, total_amount, vendorID, payment_type
FROM rides;

SELECT * FROM rides_part LIMIT 5;
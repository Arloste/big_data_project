DROP TABLE IF EXISTS rides;

CREATE TABLE IF NOT EXISTS rides (
	vendorID		SMALLINT,
	pickup_time		TIMESTAMP,
	dropoff_time		TIMESTAMP,
	passenger_count		INTEGER,
	trip_distance		DECIMAL(20,2),
	pickup_longitude	DECIMAL(20,2),
	pickup_latitude		DECIMAL(20,2),
	rateCodeId		SMALLINT,
	store_and_fwd_flag	VARCHAR(1),
	dropoff_longitude	DECIMAL(20,2),
	dropoff_latitude	DECIMAL(20,2),
	payment_type		SMALLINT,
	fare_amount		DECIMAL(20,2),
	extra			DECIMAL(20,2),
	mta_tax			DECIMAL(20,2),
	improvement_surcharge	DECIMAL(20,2),
	tip_amount		DECIMAL(20,2),
	tolls_amount		DECIMAL(20,2),
	total_amount		DECIMAL(20,2)

);

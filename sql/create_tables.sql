DROP TABLE IF EXISTS rides;

CREATE TABLE IF NOT EXISTS rides (
	vendorID		SMALLINT,
	pickup_time		TIMESTAMP,
	dropoff_time		TIMESTAMP,
	passenger_count		INTEGER,
	trip_distance		DECIMAL,
	pickup_longitude	DECIMAL,
	pickup_latitude		DECIMAL,
	rateCodeId		SMALLINT,
	store_and_fwd_flag	VARCHAR(1),
	dropoff_longitude	DECIMAL,
	dropoff_latitude	DECIMAL,
	payment_type		SMALLINT,
	fare_amount		DECIMAL,
	extra			DECIMAL,
	mta_tax			DECIMAL,
	improvement_surcharge	DECIMAL,
	tip_amount		DECIMAL,
	tolls_amount		DECIMAL,
	total_amount		DECIMAL

);

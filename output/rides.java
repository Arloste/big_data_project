// ORM class for table 'rides'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Sun Apr 14 19:40:04 MSK 2024
// For connector: org.apache.sqoop.manager.PostgresqlManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import org.apache.sqoop.lib.JdbcWritableBridge;
import org.apache.sqoop.lib.DelimiterSet;
import org.apache.sqoop.lib.FieldFormatter;
import org.apache.sqoop.lib.RecordParser;
import org.apache.sqoop.lib.BooleanParser;
import org.apache.sqoop.lib.BlobRef;
import org.apache.sqoop.lib.ClobRef;
import org.apache.sqoop.lib.LargeObjectLoader;
import org.apache.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class rides extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("vendorid", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        rides.this.vendorid = (Integer)value;
      }
    });
    setters.put("pickup_time", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        rides.this.pickup_time = (java.sql.Timestamp)value;
      }
    });
    setters.put("dropoff_time", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        rides.this.dropoff_time = (java.sql.Timestamp)value;
      }
    });
    setters.put("passenger_count", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        rides.this.passenger_count = (Integer)value;
      }
    });
    setters.put("trip_distance", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        rides.this.trip_distance = (java.math.BigDecimal)value;
      }
    });
    setters.put("pickup_longitude", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        rides.this.pickup_longitude = (java.math.BigDecimal)value;
      }
    });
    setters.put("pickup_latitude", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        rides.this.pickup_latitude = (java.math.BigDecimal)value;
      }
    });
    setters.put("ratecodeid", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        rides.this.ratecodeid = (Integer)value;
      }
    });
    setters.put("store_and_fwd_flag", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        rides.this.store_and_fwd_flag = (String)value;
      }
    });
    setters.put("dropoff_longitude", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        rides.this.dropoff_longitude = (java.math.BigDecimal)value;
      }
    });
    setters.put("dropoff_latitude", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        rides.this.dropoff_latitude = (java.math.BigDecimal)value;
      }
    });
    setters.put("payment_type", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        rides.this.payment_type = (Integer)value;
      }
    });
    setters.put("fare_amount", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        rides.this.fare_amount = (java.math.BigDecimal)value;
      }
    });
    setters.put("extra", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        rides.this.extra = (java.math.BigDecimal)value;
      }
    });
    setters.put("mta_tax", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        rides.this.mta_tax = (java.math.BigDecimal)value;
      }
    });
    setters.put("improvement_surcharge", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        rides.this.improvement_surcharge = (java.math.BigDecimal)value;
      }
    });
    setters.put("tip_amount", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        rides.this.tip_amount = (java.math.BigDecimal)value;
      }
    });
    setters.put("tolls_amount", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        rides.this.tolls_amount = (java.math.BigDecimal)value;
      }
    });
    setters.put("total_amount", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        rides.this.total_amount = (java.math.BigDecimal)value;
      }
    });
  }
  public rides() {
    init0();
  }
  private Integer vendorid;
  public Integer get_vendorid() {
    return vendorid;
  }
  public void set_vendorid(Integer vendorid) {
    this.vendorid = vendorid;
  }
  public rides with_vendorid(Integer vendorid) {
    this.vendorid = vendorid;
    return this;
  }
  private java.sql.Timestamp pickup_time;
  public java.sql.Timestamp get_pickup_time() {
    return pickup_time;
  }
  public void set_pickup_time(java.sql.Timestamp pickup_time) {
    this.pickup_time = pickup_time;
  }
  public rides with_pickup_time(java.sql.Timestamp pickup_time) {
    this.pickup_time = pickup_time;
    return this;
  }
  private java.sql.Timestamp dropoff_time;
  public java.sql.Timestamp get_dropoff_time() {
    return dropoff_time;
  }
  public void set_dropoff_time(java.sql.Timestamp dropoff_time) {
    this.dropoff_time = dropoff_time;
  }
  public rides with_dropoff_time(java.sql.Timestamp dropoff_time) {
    this.dropoff_time = dropoff_time;
    return this;
  }
  private Integer passenger_count;
  public Integer get_passenger_count() {
    return passenger_count;
  }
  public void set_passenger_count(Integer passenger_count) {
    this.passenger_count = passenger_count;
  }
  public rides with_passenger_count(Integer passenger_count) {
    this.passenger_count = passenger_count;
    return this;
  }
  private java.math.BigDecimal trip_distance;
  public java.math.BigDecimal get_trip_distance() {
    return trip_distance;
  }
  public void set_trip_distance(java.math.BigDecimal trip_distance) {
    this.trip_distance = trip_distance;
  }
  public rides with_trip_distance(java.math.BigDecimal trip_distance) {
    this.trip_distance = trip_distance;
    return this;
  }
  private java.math.BigDecimal pickup_longitude;
  public java.math.BigDecimal get_pickup_longitude() {
    return pickup_longitude;
  }
  public void set_pickup_longitude(java.math.BigDecimal pickup_longitude) {
    this.pickup_longitude = pickup_longitude;
  }
  public rides with_pickup_longitude(java.math.BigDecimal pickup_longitude) {
    this.pickup_longitude = pickup_longitude;
    return this;
  }
  private java.math.BigDecimal pickup_latitude;
  public java.math.BigDecimal get_pickup_latitude() {
    return pickup_latitude;
  }
  public void set_pickup_latitude(java.math.BigDecimal pickup_latitude) {
    this.pickup_latitude = pickup_latitude;
  }
  public rides with_pickup_latitude(java.math.BigDecimal pickup_latitude) {
    this.pickup_latitude = pickup_latitude;
    return this;
  }
  private Integer ratecodeid;
  public Integer get_ratecodeid() {
    return ratecodeid;
  }
  public void set_ratecodeid(Integer ratecodeid) {
    this.ratecodeid = ratecodeid;
  }
  public rides with_ratecodeid(Integer ratecodeid) {
    this.ratecodeid = ratecodeid;
    return this;
  }
  private String store_and_fwd_flag;
  public String get_store_and_fwd_flag() {
    return store_and_fwd_flag;
  }
  public void set_store_and_fwd_flag(String store_and_fwd_flag) {
    this.store_and_fwd_flag = store_and_fwd_flag;
  }
  public rides with_store_and_fwd_flag(String store_and_fwd_flag) {
    this.store_and_fwd_flag = store_and_fwd_flag;
    return this;
  }
  private java.math.BigDecimal dropoff_longitude;
  public java.math.BigDecimal get_dropoff_longitude() {
    return dropoff_longitude;
  }
  public void set_dropoff_longitude(java.math.BigDecimal dropoff_longitude) {
    this.dropoff_longitude = dropoff_longitude;
  }
  public rides with_dropoff_longitude(java.math.BigDecimal dropoff_longitude) {
    this.dropoff_longitude = dropoff_longitude;
    return this;
  }
  private java.math.BigDecimal dropoff_latitude;
  public java.math.BigDecimal get_dropoff_latitude() {
    return dropoff_latitude;
  }
  public void set_dropoff_latitude(java.math.BigDecimal dropoff_latitude) {
    this.dropoff_latitude = dropoff_latitude;
  }
  public rides with_dropoff_latitude(java.math.BigDecimal dropoff_latitude) {
    this.dropoff_latitude = dropoff_latitude;
    return this;
  }
  private Integer payment_type;
  public Integer get_payment_type() {
    return payment_type;
  }
  public void set_payment_type(Integer payment_type) {
    this.payment_type = payment_type;
  }
  public rides with_payment_type(Integer payment_type) {
    this.payment_type = payment_type;
    return this;
  }
  private java.math.BigDecimal fare_amount;
  public java.math.BigDecimal get_fare_amount() {
    return fare_amount;
  }
  public void set_fare_amount(java.math.BigDecimal fare_amount) {
    this.fare_amount = fare_amount;
  }
  public rides with_fare_amount(java.math.BigDecimal fare_amount) {
    this.fare_amount = fare_amount;
    return this;
  }
  private java.math.BigDecimal extra;
  public java.math.BigDecimal get_extra() {
    return extra;
  }
  public void set_extra(java.math.BigDecimal extra) {
    this.extra = extra;
  }
  public rides with_extra(java.math.BigDecimal extra) {
    this.extra = extra;
    return this;
  }
  private java.math.BigDecimal mta_tax;
  public java.math.BigDecimal get_mta_tax() {
    return mta_tax;
  }
  public void set_mta_tax(java.math.BigDecimal mta_tax) {
    this.mta_tax = mta_tax;
  }
  public rides with_mta_tax(java.math.BigDecimal mta_tax) {
    this.mta_tax = mta_tax;
    return this;
  }
  private java.math.BigDecimal improvement_surcharge;
  public java.math.BigDecimal get_improvement_surcharge() {
    return improvement_surcharge;
  }
  public void set_improvement_surcharge(java.math.BigDecimal improvement_surcharge) {
    this.improvement_surcharge = improvement_surcharge;
  }
  public rides with_improvement_surcharge(java.math.BigDecimal improvement_surcharge) {
    this.improvement_surcharge = improvement_surcharge;
    return this;
  }
  private java.math.BigDecimal tip_amount;
  public java.math.BigDecimal get_tip_amount() {
    return tip_amount;
  }
  public void set_tip_amount(java.math.BigDecimal tip_amount) {
    this.tip_amount = tip_amount;
  }
  public rides with_tip_amount(java.math.BigDecimal tip_amount) {
    this.tip_amount = tip_amount;
    return this;
  }
  private java.math.BigDecimal tolls_amount;
  public java.math.BigDecimal get_tolls_amount() {
    return tolls_amount;
  }
  public void set_tolls_amount(java.math.BigDecimal tolls_amount) {
    this.tolls_amount = tolls_amount;
  }
  public rides with_tolls_amount(java.math.BigDecimal tolls_amount) {
    this.tolls_amount = tolls_amount;
    return this;
  }
  private java.math.BigDecimal total_amount;
  public java.math.BigDecimal get_total_amount() {
    return total_amount;
  }
  public void set_total_amount(java.math.BigDecimal total_amount) {
    this.total_amount = total_amount;
  }
  public rides with_total_amount(java.math.BigDecimal total_amount) {
    this.total_amount = total_amount;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof rides)) {
      return false;
    }
    rides that = (rides) o;
    boolean equal = true;
    equal = equal && (this.vendorid == null ? that.vendorid == null : this.vendorid.equals(that.vendorid));
    equal = equal && (this.pickup_time == null ? that.pickup_time == null : this.pickup_time.equals(that.pickup_time));
    equal = equal && (this.dropoff_time == null ? that.dropoff_time == null : this.dropoff_time.equals(that.dropoff_time));
    equal = equal && (this.passenger_count == null ? that.passenger_count == null : this.passenger_count.equals(that.passenger_count));
    equal = equal && (this.trip_distance == null ? that.trip_distance == null : this.trip_distance.equals(that.trip_distance));
    equal = equal && (this.pickup_longitude == null ? that.pickup_longitude == null : this.pickup_longitude.equals(that.pickup_longitude));
    equal = equal && (this.pickup_latitude == null ? that.pickup_latitude == null : this.pickup_latitude.equals(that.pickup_latitude));
    equal = equal && (this.ratecodeid == null ? that.ratecodeid == null : this.ratecodeid.equals(that.ratecodeid));
    equal = equal && (this.store_and_fwd_flag == null ? that.store_and_fwd_flag == null : this.store_and_fwd_flag.equals(that.store_and_fwd_flag));
    equal = equal && (this.dropoff_longitude == null ? that.dropoff_longitude == null : this.dropoff_longitude.equals(that.dropoff_longitude));
    equal = equal && (this.dropoff_latitude == null ? that.dropoff_latitude == null : this.dropoff_latitude.equals(that.dropoff_latitude));
    equal = equal && (this.payment_type == null ? that.payment_type == null : this.payment_type.equals(that.payment_type));
    equal = equal && (this.fare_amount == null ? that.fare_amount == null : this.fare_amount.equals(that.fare_amount));
    equal = equal && (this.extra == null ? that.extra == null : this.extra.equals(that.extra));
    equal = equal && (this.mta_tax == null ? that.mta_tax == null : this.mta_tax.equals(that.mta_tax));
    equal = equal && (this.improvement_surcharge == null ? that.improvement_surcharge == null : this.improvement_surcharge.equals(that.improvement_surcharge));
    equal = equal && (this.tip_amount == null ? that.tip_amount == null : this.tip_amount.equals(that.tip_amount));
    equal = equal && (this.tolls_amount == null ? that.tolls_amount == null : this.tolls_amount.equals(that.tolls_amount));
    equal = equal && (this.total_amount == null ? that.total_amount == null : this.total_amount.equals(that.total_amount));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof rides)) {
      return false;
    }
    rides that = (rides) o;
    boolean equal = true;
    equal = equal && (this.vendorid == null ? that.vendorid == null : this.vendorid.equals(that.vendorid));
    equal = equal && (this.pickup_time == null ? that.pickup_time == null : this.pickup_time.equals(that.pickup_time));
    equal = equal && (this.dropoff_time == null ? that.dropoff_time == null : this.dropoff_time.equals(that.dropoff_time));
    equal = equal && (this.passenger_count == null ? that.passenger_count == null : this.passenger_count.equals(that.passenger_count));
    equal = equal && (this.trip_distance == null ? that.trip_distance == null : this.trip_distance.equals(that.trip_distance));
    equal = equal && (this.pickup_longitude == null ? that.pickup_longitude == null : this.pickup_longitude.equals(that.pickup_longitude));
    equal = equal && (this.pickup_latitude == null ? that.pickup_latitude == null : this.pickup_latitude.equals(that.pickup_latitude));
    equal = equal && (this.ratecodeid == null ? that.ratecodeid == null : this.ratecodeid.equals(that.ratecodeid));
    equal = equal && (this.store_and_fwd_flag == null ? that.store_and_fwd_flag == null : this.store_and_fwd_flag.equals(that.store_and_fwd_flag));
    equal = equal && (this.dropoff_longitude == null ? that.dropoff_longitude == null : this.dropoff_longitude.equals(that.dropoff_longitude));
    equal = equal && (this.dropoff_latitude == null ? that.dropoff_latitude == null : this.dropoff_latitude.equals(that.dropoff_latitude));
    equal = equal && (this.payment_type == null ? that.payment_type == null : this.payment_type.equals(that.payment_type));
    equal = equal && (this.fare_amount == null ? that.fare_amount == null : this.fare_amount.equals(that.fare_amount));
    equal = equal && (this.extra == null ? that.extra == null : this.extra.equals(that.extra));
    equal = equal && (this.mta_tax == null ? that.mta_tax == null : this.mta_tax.equals(that.mta_tax));
    equal = equal && (this.improvement_surcharge == null ? that.improvement_surcharge == null : this.improvement_surcharge.equals(that.improvement_surcharge));
    equal = equal && (this.tip_amount == null ? that.tip_amount == null : this.tip_amount.equals(that.tip_amount));
    equal = equal && (this.tolls_amount == null ? that.tolls_amount == null : this.tolls_amount.equals(that.tolls_amount));
    equal = equal && (this.total_amount == null ? that.total_amount == null : this.total_amount.equals(that.total_amount));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.vendorid = JdbcWritableBridge.readInteger(1, __dbResults);
    this.pickup_time = JdbcWritableBridge.readTimestamp(2, __dbResults);
    this.dropoff_time = JdbcWritableBridge.readTimestamp(3, __dbResults);
    this.passenger_count = JdbcWritableBridge.readInteger(4, __dbResults);
    this.trip_distance = JdbcWritableBridge.readBigDecimal(5, __dbResults);
    this.pickup_longitude = JdbcWritableBridge.readBigDecimal(6, __dbResults);
    this.pickup_latitude = JdbcWritableBridge.readBigDecimal(7, __dbResults);
    this.ratecodeid = JdbcWritableBridge.readInteger(8, __dbResults);
    this.store_and_fwd_flag = JdbcWritableBridge.readString(9, __dbResults);
    this.dropoff_longitude = JdbcWritableBridge.readBigDecimal(10, __dbResults);
    this.dropoff_latitude = JdbcWritableBridge.readBigDecimal(11, __dbResults);
    this.payment_type = JdbcWritableBridge.readInteger(12, __dbResults);
    this.fare_amount = JdbcWritableBridge.readBigDecimal(13, __dbResults);
    this.extra = JdbcWritableBridge.readBigDecimal(14, __dbResults);
    this.mta_tax = JdbcWritableBridge.readBigDecimal(15, __dbResults);
    this.improvement_surcharge = JdbcWritableBridge.readBigDecimal(16, __dbResults);
    this.tip_amount = JdbcWritableBridge.readBigDecimal(17, __dbResults);
    this.tolls_amount = JdbcWritableBridge.readBigDecimal(18, __dbResults);
    this.total_amount = JdbcWritableBridge.readBigDecimal(19, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.vendorid = JdbcWritableBridge.readInteger(1, __dbResults);
    this.pickup_time = JdbcWritableBridge.readTimestamp(2, __dbResults);
    this.dropoff_time = JdbcWritableBridge.readTimestamp(3, __dbResults);
    this.passenger_count = JdbcWritableBridge.readInteger(4, __dbResults);
    this.trip_distance = JdbcWritableBridge.readBigDecimal(5, __dbResults);
    this.pickup_longitude = JdbcWritableBridge.readBigDecimal(6, __dbResults);
    this.pickup_latitude = JdbcWritableBridge.readBigDecimal(7, __dbResults);
    this.ratecodeid = JdbcWritableBridge.readInteger(8, __dbResults);
    this.store_and_fwd_flag = JdbcWritableBridge.readString(9, __dbResults);
    this.dropoff_longitude = JdbcWritableBridge.readBigDecimal(10, __dbResults);
    this.dropoff_latitude = JdbcWritableBridge.readBigDecimal(11, __dbResults);
    this.payment_type = JdbcWritableBridge.readInteger(12, __dbResults);
    this.fare_amount = JdbcWritableBridge.readBigDecimal(13, __dbResults);
    this.extra = JdbcWritableBridge.readBigDecimal(14, __dbResults);
    this.mta_tax = JdbcWritableBridge.readBigDecimal(15, __dbResults);
    this.improvement_surcharge = JdbcWritableBridge.readBigDecimal(16, __dbResults);
    this.tip_amount = JdbcWritableBridge.readBigDecimal(17, __dbResults);
    this.tolls_amount = JdbcWritableBridge.readBigDecimal(18, __dbResults);
    this.total_amount = JdbcWritableBridge.readBigDecimal(19, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(vendorid, 1 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeTimestamp(pickup_time, 2 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeTimestamp(dropoff_time, 3 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeInteger(passenger_count, 4 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(trip_distance, 5 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(pickup_longitude, 6 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(pickup_latitude, 7 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeInteger(ratecodeid, 8 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeString(store_and_fwd_flag, 9 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(dropoff_longitude, 10 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(dropoff_latitude, 11 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeInteger(payment_type, 12 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(fare_amount, 13 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(extra, 14 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(mta_tax, 15 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(improvement_surcharge, 16 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(tip_amount, 17 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(tolls_amount, 18 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(total_amount, 19 + __off, 2, __dbStmt);
    return 19;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(vendorid, 1 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeTimestamp(pickup_time, 2 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeTimestamp(dropoff_time, 3 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeInteger(passenger_count, 4 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(trip_distance, 5 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(pickup_longitude, 6 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(pickup_latitude, 7 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeInteger(ratecodeid, 8 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeString(store_and_fwd_flag, 9 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(dropoff_longitude, 10 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(dropoff_latitude, 11 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeInteger(payment_type, 12 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(fare_amount, 13 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(extra, 14 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(mta_tax, 15 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(improvement_surcharge, 16 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(tip_amount, 17 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(tolls_amount, 18 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(total_amount, 19 + __off, 2, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.vendorid = null;
    } else {
    this.vendorid = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.pickup_time = null;
    } else {
    this.pickup_time = new Timestamp(__dataIn.readLong());
    this.pickup_time.setNanos(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.dropoff_time = null;
    } else {
    this.dropoff_time = new Timestamp(__dataIn.readLong());
    this.dropoff_time.setNanos(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.passenger_count = null;
    } else {
    this.passenger_count = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.trip_distance = null;
    } else {
    this.trip_distance = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.pickup_longitude = null;
    } else {
    this.pickup_longitude = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.pickup_latitude = null;
    } else {
    this.pickup_latitude = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.ratecodeid = null;
    } else {
    this.ratecodeid = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.store_and_fwd_flag = null;
    } else {
    this.store_and_fwd_flag = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.dropoff_longitude = null;
    } else {
    this.dropoff_longitude = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.dropoff_latitude = null;
    } else {
    this.dropoff_latitude = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.payment_type = null;
    } else {
    this.payment_type = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.fare_amount = null;
    } else {
    this.fare_amount = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.extra = null;
    } else {
    this.extra = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.mta_tax = null;
    } else {
    this.mta_tax = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.improvement_surcharge = null;
    } else {
    this.improvement_surcharge = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.tip_amount = null;
    } else {
    this.tip_amount = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.tolls_amount = null;
    } else {
    this.tolls_amount = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.total_amount = null;
    } else {
    this.total_amount = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.vendorid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.vendorid);
    }
    if (null == this.pickup_time) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.pickup_time.getTime());
    __dataOut.writeInt(this.pickup_time.getNanos());
    }
    if (null == this.dropoff_time) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.dropoff_time.getTime());
    __dataOut.writeInt(this.dropoff_time.getNanos());
    }
    if (null == this.passenger_count) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.passenger_count);
    }
    if (null == this.trip_distance) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.trip_distance, __dataOut);
    }
    if (null == this.pickup_longitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.pickup_longitude, __dataOut);
    }
    if (null == this.pickup_latitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.pickup_latitude, __dataOut);
    }
    if (null == this.ratecodeid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.ratecodeid);
    }
    if (null == this.store_and_fwd_flag) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, store_and_fwd_flag);
    }
    if (null == this.dropoff_longitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.dropoff_longitude, __dataOut);
    }
    if (null == this.dropoff_latitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.dropoff_latitude, __dataOut);
    }
    if (null == this.payment_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.payment_type);
    }
    if (null == this.fare_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.fare_amount, __dataOut);
    }
    if (null == this.extra) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.extra, __dataOut);
    }
    if (null == this.mta_tax) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.mta_tax, __dataOut);
    }
    if (null == this.improvement_surcharge) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.improvement_surcharge, __dataOut);
    }
    if (null == this.tip_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.tip_amount, __dataOut);
    }
    if (null == this.tolls_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.tolls_amount, __dataOut);
    }
    if (null == this.total_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.total_amount, __dataOut);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.vendorid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.vendorid);
    }
    if (null == this.pickup_time) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.pickup_time.getTime());
    __dataOut.writeInt(this.pickup_time.getNanos());
    }
    if (null == this.dropoff_time) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.dropoff_time.getTime());
    __dataOut.writeInt(this.dropoff_time.getNanos());
    }
    if (null == this.passenger_count) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.passenger_count);
    }
    if (null == this.trip_distance) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.trip_distance, __dataOut);
    }
    if (null == this.pickup_longitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.pickup_longitude, __dataOut);
    }
    if (null == this.pickup_latitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.pickup_latitude, __dataOut);
    }
    if (null == this.ratecodeid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.ratecodeid);
    }
    if (null == this.store_and_fwd_flag) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, store_and_fwd_flag);
    }
    if (null == this.dropoff_longitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.dropoff_longitude, __dataOut);
    }
    if (null == this.dropoff_latitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.dropoff_latitude, __dataOut);
    }
    if (null == this.payment_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.payment_type);
    }
    if (null == this.fare_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.fare_amount, __dataOut);
    }
    if (null == this.extra) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.extra, __dataOut);
    }
    if (null == this.mta_tax) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.mta_tax, __dataOut);
    }
    if (null == this.improvement_surcharge) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.improvement_surcharge, __dataOut);
    }
    if (null == this.tip_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.tip_amount, __dataOut);
    }
    if (null == this.tolls_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.tolls_amount, __dataOut);
    }
    if (null == this.total_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.total_amount, __dataOut);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(vendorid==null?"null":"" + vendorid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(pickup_time==null?"null":"" + pickup_time, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dropoff_time==null?"null":"" + dropoff_time, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(passenger_count==null?"null":"" + passenger_count, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(trip_distance==null?"null":trip_distance.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(pickup_longitude==null?"null":pickup_longitude.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(pickup_latitude==null?"null":pickup_latitude.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(ratecodeid==null?"null":"" + ratecodeid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(store_and_fwd_flag==null?"null":store_and_fwd_flag, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dropoff_longitude==null?"null":dropoff_longitude.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dropoff_latitude==null?"null":dropoff_latitude.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(payment_type==null?"null":"" + payment_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fare_amount==null?"null":fare_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(extra==null?"null":extra.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(mta_tax==null?"null":mta_tax.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(improvement_surcharge==null?"null":improvement_surcharge.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(tip_amount==null?"null":tip_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(tolls_amount==null?"null":tolls_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(total_amount==null?"null":total_amount.toPlainString(), delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(vendorid==null?"null":"" + vendorid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(pickup_time==null?"null":"" + pickup_time, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dropoff_time==null?"null":"" + dropoff_time, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(passenger_count==null?"null":"" + passenger_count, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(trip_distance==null?"null":trip_distance.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(pickup_longitude==null?"null":pickup_longitude.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(pickup_latitude==null?"null":pickup_latitude.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(ratecodeid==null?"null":"" + ratecodeid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(store_and_fwd_flag==null?"null":store_and_fwd_flag, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dropoff_longitude==null?"null":dropoff_longitude.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dropoff_latitude==null?"null":dropoff_latitude.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(payment_type==null?"null":"" + payment_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fare_amount==null?"null":fare_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(extra==null?"null":extra.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(mta_tax==null?"null":mta_tax.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(improvement_surcharge==null?"null":improvement_surcharge.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(tip_amount==null?"null":tip_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(tolls_amount==null?"null":tolls_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(total_amount==null?"null":total_amount.toPlainString(), delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.vendorid = null; } else {
      this.vendorid = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.pickup_time = null; } else {
      this.pickup_time = java.sql.Timestamp.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.dropoff_time = null; } else {
      this.dropoff_time = java.sql.Timestamp.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.passenger_count = null; } else {
      this.passenger_count = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.trip_distance = null; } else {
      this.trip_distance = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.pickup_longitude = null; } else {
      this.pickup_longitude = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.pickup_latitude = null; } else {
      this.pickup_latitude = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.ratecodeid = null; } else {
      this.ratecodeid = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.store_and_fwd_flag = null; } else {
      this.store_and_fwd_flag = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.dropoff_longitude = null; } else {
      this.dropoff_longitude = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.dropoff_latitude = null; } else {
      this.dropoff_latitude = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.payment_type = null; } else {
      this.payment_type = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.fare_amount = null; } else {
      this.fare_amount = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.extra = null; } else {
      this.extra = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.mta_tax = null; } else {
      this.mta_tax = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.improvement_surcharge = null; } else {
      this.improvement_surcharge = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.tip_amount = null; } else {
      this.tip_amount = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.tolls_amount = null; } else {
      this.tolls_amount = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.total_amount = null; } else {
      this.total_amount = new java.math.BigDecimal(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.vendorid = null; } else {
      this.vendorid = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.pickup_time = null; } else {
      this.pickup_time = java.sql.Timestamp.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.dropoff_time = null; } else {
      this.dropoff_time = java.sql.Timestamp.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.passenger_count = null; } else {
      this.passenger_count = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.trip_distance = null; } else {
      this.trip_distance = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.pickup_longitude = null; } else {
      this.pickup_longitude = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.pickup_latitude = null; } else {
      this.pickup_latitude = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.ratecodeid = null; } else {
      this.ratecodeid = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.store_and_fwd_flag = null; } else {
      this.store_and_fwd_flag = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.dropoff_longitude = null; } else {
      this.dropoff_longitude = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.dropoff_latitude = null; } else {
      this.dropoff_latitude = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.payment_type = null; } else {
      this.payment_type = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.fare_amount = null; } else {
      this.fare_amount = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.extra = null; } else {
      this.extra = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.mta_tax = null; } else {
      this.mta_tax = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.improvement_surcharge = null; } else {
      this.improvement_surcharge = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.tip_amount = null; } else {
      this.tip_amount = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.tolls_amount = null; } else {
      this.tolls_amount = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.total_amount = null; } else {
      this.total_amount = new java.math.BigDecimal(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    rides o = (rides) super.clone();
    o.pickup_time = (o.pickup_time != null) ? (java.sql.Timestamp) o.pickup_time.clone() : null;
    o.dropoff_time = (o.dropoff_time != null) ? (java.sql.Timestamp) o.dropoff_time.clone() : null;
    return o;
  }

  public void clone0(rides o) throws CloneNotSupportedException {
    o.pickup_time = (o.pickup_time != null) ? (java.sql.Timestamp) o.pickup_time.clone() : null;
    o.dropoff_time = (o.dropoff_time != null) ? (java.sql.Timestamp) o.dropoff_time.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("vendorid", this.vendorid);
    __sqoop$field_map.put("pickup_time", this.pickup_time);
    __sqoop$field_map.put("dropoff_time", this.dropoff_time);
    __sqoop$field_map.put("passenger_count", this.passenger_count);
    __sqoop$field_map.put("trip_distance", this.trip_distance);
    __sqoop$field_map.put("pickup_longitude", this.pickup_longitude);
    __sqoop$field_map.put("pickup_latitude", this.pickup_latitude);
    __sqoop$field_map.put("ratecodeid", this.ratecodeid);
    __sqoop$field_map.put("store_and_fwd_flag", this.store_and_fwd_flag);
    __sqoop$field_map.put("dropoff_longitude", this.dropoff_longitude);
    __sqoop$field_map.put("dropoff_latitude", this.dropoff_latitude);
    __sqoop$field_map.put("payment_type", this.payment_type);
    __sqoop$field_map.put("fare_amount", this.fare_amount);
    __sqoop$field_map.put("extra", this.extra);
    __sqoop$field_map.put("mta_tax", this.mta_tax);
    __sqoop$field_map.put("improvement_surcharge", this.improvement_surcharge);
    __sqoop$field_map.put("tip_amount", this.tip_amount);
    __sqoop$field_map.put("tolls_amount", this.tolls_amount);
    __sqoop$field_map.put("total_amount", this.total_amount);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("vendorid", this.vendorid);
    __sqoop$field_map.put("pickup_time", this.pickup_time);
    __sqoop$field_map.put("dropoff_time", this.dropoff_time);
    __sqoop$field_map.put("passenger_count", this.passenger_count);
    __sqoop$field_map.put("trip_distance", this.trip_distance);
    __sqoop$field_map.put("pickup_longitude", this.pickup_longitude);
    __sqoop$field_map.put("pickup_latitude", this.pickup_latitude);
    __sqoop$field_map.put("ratecodeid", this.ratecodeid);
    __sqoop$field_map.put("store_and_fwd_flag", this.store_and_fwd_flag);
    __sqoop$field_map.put("dropoff_longitude", this.dropoff_longitude);
    __sqoop$field_map.put("dropoff_latitude", this.dropoff_latitude);
    __sqoop$field_map.put("payment_type", this.payment_type);
    __sqoop$field_map.put("fare_amount", this.fare_amount);
    __sqoop$field_map.put("extra", this.extra);
    __sqoop$field_map.put("mta_tax", this.mta_tax);
    __sqoop$field_map.put("improvement_surcharge", this.improvement_surcharge);
    __sqoop$field_map.put("tip_amount", this.tip_amount);
    __sqoop$field_map.put("tolls_amount", this.tolls_amount);
    __sqoop$field_map.put("total_amount", this.total_amount);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}

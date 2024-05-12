#!/bin/bash
echo "LOGGER: Started ML Modeling"
export HADOOP_CONF_DIR=/etc/hadoop/conf
spark-submit --master yarn scripts/MLModeling.py
echo "LOGGER: ML Modeling finished"
#!/bin/bash
echo "LOGGER: Creating Hive tables for results."
password="GEEzBg4UuiWuNj0T"
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team30 -p $password -f sql/regression_results.hql
echo "LOGGER: Tabels created."
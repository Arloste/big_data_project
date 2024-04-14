"""
Module to build the remote PostgreSQL database.

This module establishes a connection to a remote PostgreSQL database using psycopg2 library,
 creates tables and imports data from CSV files, and executes SQL commands stored in separate files.

Attributes:
    CONN_STRING (str): Connection string for the PostgreSQL database.
    DATASET_PATH (str): Path to the CSV dataset file.

Dependencies:
    - os
    - pprint
    - psycopg2 (installed as psql)
"""

import os
from pprint import pprint

import psycopg2 as psql


# Read password from secrets file
file = os.path.join("secrets", ".psql.pass")
with open(file, "r", encoding="utf-8") as file:
    password=file.read().rstrip()


CONN_STRING = f"host=hadoop-04.uni.innopolis.ru port=5432 user=team30\
          dbname=team30_projectdb password={password}"
DATASET_PATH = "yellow_tripdata_2015-01.csv"


# Connect to the remote dbms
with psql.connect(CONN_STRING) as conn:
    print("DEBUG: Connection established.")
    # Create a cursor for executing psql commands
    cur = conn.cursor()
    # Read the commands from the file and execute them.
    with open(os.path.join("sql","create_tables.sql"), encoding="utf-8") as file:
        content = file.read()
        cur.execute(content)
    conn.commit()
    print("DEBUG: Tables created.")
    # Read the commands from the file and execute them.
    with open(os.path.join("sql", "import_data.sql"), encoding="utf-8") as file:
        # We assume that the COPY commands in the file are ordered (1.depts, 2.emps)
        commands= file.readlines()
        with open(os.path.join("data", DATASET_PATH), mode="r", encoding="utf-8") as depts:
            cur.copy_expert(commands[0], depts)

    # If the sql statements are CRUD then you need to commit the change
    conn.commit()

    pprint(conn)
    cur = conn.cursor()
    # Read the sql commands from the file
    with open(os.path.join("sql", "test_database.sql"), encoding="utf-8") as file:
        commands = file.readlines()
        for command in commands:
            cur.execute(command)
            # Read all records and print them
            pprint(cur.fetchall())

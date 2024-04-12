import psycopg2 as psql
from pprint import pprint
import os

conn_string = "host=hadoop-04.uni.innopolis.ru port=5432 user=team30 dbname=team30_projectdb password=GEEzBg4UuiWuNj0T"
dataset_path = "yellow_tripdata_2015-01.csv"

# Connect to the remote dbms
with psql.connect(conn_string) as conn:

        # Create a cursor for executing psql commands
        cur = conn.cursor()
        # Read the commands from the file and execute them.
        with open(os.path.join("sql","create_tables.sql")) as file:
                content = file.read()
                cur.execute(content)
        conn.commit()

        # Read the commands from the file and execute them.
        with open(os.path.join("sql", "import_data.sql")) as file:
                # We assume that the COPY commands in the file are ordered (1.depts, 2.emps)
                commands= file.readlines()
                with open(os.path.join("data",dataset_path), "r") as depts:
                        cur.copy_expert(commands[0], depts)
                #with open(os.path.join("data","emps.csv"), "r") as emps:
                #        cur.copy_expert(commands[1], emps)

        # If the sql statements are CRUD then you need to commit the change
        conn.commit()

        pprint(conn)
        cur = conn.cursor()
        # Read the sql commands from the file
        with open(os.path.join("sql", "test_database.sql")) as file:
                commands = file.readlines()
                for command in commands:
                        cur.execute(command)
                        # Read all records and print them
                        pprint(cur.fetchall())

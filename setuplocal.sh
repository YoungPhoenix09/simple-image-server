#!/usr/bin/env bash
docker-compose up -d
sleep 5
docker cp ./src/main/resources/db/initDb/create_database.sql "postgres_db":/
docker exec -e PGPASSWORD=postgres "postgres_db" psql -h "postgres_db" -d postgres -U postgres -a -f create_database.sql

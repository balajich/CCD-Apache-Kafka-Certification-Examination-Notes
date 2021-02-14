#!/bin/bash
echo "Creating seed data for this repo in kafka cluster - Start"
# Create topic
docker-compose exec broker-1 kafka-topics \
  --create \
  --topic hello-world-topic\
  --bootstrap-server broker-1:19092

# Create topic
docker-compose exec broker-1 kafka-topics \
  --create \
  --topic student-topic\
  --replication-factor 3 \
  --partitions 8 \
  --bootstrap-server broker-1:19092

echo "Creating seed data for this repo in kafka cluster - Done"
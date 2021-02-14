#!/bin/bash
echo "Cleans the seeded data in kafka cluster"
# Delete a topic
docker-compose exec broker-1 kafka-topics \
  --delete \
  --topic hello-world-topic \
  --bootstrap-server broker-1:19092

# Delete a topic
docker-compose exec broker-1 kafka-topics \
  --delete \
  --topic student-topic \
  --bootstrap-server broker-1:19092

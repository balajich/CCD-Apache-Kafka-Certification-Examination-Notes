# Create topic
docker-compose exec broker-1 kafka-topics \
  --create \
  --topic student-topic\
  --replication-factor 3 \
  --partitions 8 \
  --bootstrap-server broker-1:19092

# Increase partitions of a topic
docker-compose exec broker-1 kafka-topics \
  --alter \
  --topic student-topic \
  --partitions 16 \
  --bootstrap-server broker-1:19092


# Delete a topic
docker-compose exec broker-1 kafka-topics \
  --delete \
  --topic student-topic \
  --bootstrap-server broker-1:19092


# list all topics in cluster
docker-compose exec broker-1 kafka-topics \
  --list \
  --bootstrap-server broker-1:19092

# Describe all the topics in cluster
docker-compose exec broker-1 kafka-topics \
  --describe \
  --bootstrap-server broker-1:19092

# Read messages from student-topic
docker-compose exec broker-1 kafka-console-consumer \
  --topic hello-world-topic \
  --bootstrap-server broker-1:19092

# Read messages from student-topic from-beginning
docker-compose exec broker-1 kafka-console-consumer \
  --topic student-topic \
  --from-beginning \
  --bootstrap-server broker-1:19092

# List new consumer groups
docker-compose exec broker-1 kafka-consumer-groups \
  --list \
  --bootstrap-server broker-1:19092

## List old consumer groups
#docker-compose exec broker-1 kafka-consumer-groups \
#  --list \
#  --zookeeper broker-1:12181

# Describe a consumer group
docker-compose exec broker-1 kafka-consumer-groups \
  --describe \
  --group console-consumer-51714 \
  --bootstrap-server broker-1:19092

# write messages to student-topic, press ctrl+c to end
docker-compose exec broker-1 kafka-console-producer \
  --topic "student-topic" \
  --bootstrap-server "broker-1:19092"
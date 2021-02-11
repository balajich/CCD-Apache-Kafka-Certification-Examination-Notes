# Create topic
docker-compose exec kafka-1 kafka-topics \
  --create \
  --topic my-topic\
  --replication-factor 2 \
  --partitions 8 \
  --bootstrap-server localhost:19092


# Increase partitions of a topic
docker-compose exec kafka-1 kafka-topics \
  --alter \
  --topic my-topic \
  --partitions 16 \
  --bootstrap-server localhost:19092


# Delete a topic
docker-compose exec kafka-1 kafka-topics \
  --delete \
  --topic my-topic \
  --bootstrap-server localhost:19092


# list all topics in cluster
docker-compose exec kafka-1 kafka-topics \
  --list \
  --bootstrap-server localhost:19092

# Describe all the topics in cluster
docker-compose exec kafka-1 kafka-topics \
  --describe \
  --bootstrap-server localhost:19092

# Read messages from my-topic
docker-compose exec kafka-1 kafka-console-consumer \
  --topic my-topic \
  --bootstrap-server localhost:19092

# Read messages from my-topic from-beginning
docker-compose exec kafka-1 kafka-console-consumer \
  --topic my-topic \
  --from-beginning \
  --bootstrap-server localhost:19092

# List new consumer groups
docker-compose exec kafka-1 kafka-consumer-groups \
  --list \
  --bootstrap-server localhost:19092

## List old consumer groups
#docker-compose exec kafka-1 kafka-consumer-groups \
#  --list \
#  --zookeeper localhost:12181

# Describe a consumer group
docker-compose exec kafka-1 kafka-consumer-groups \
  --describe \
  --group console-consumer-51714 \
  --bootstrap-server localhost:19092
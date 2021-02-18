# write messages from student-topic, press ctrl+c to end
docker-compose exec broker-1 kafka-console-producer \
  --topic "hello-world-topic" \
  --bootstrap-server "broker-1:19092"

# Using echo and pipe the message that you want to publish
docker-compose exec broker-1  bash -c "echo 'Hello World' | kafka-console-producer   --topic hello-world-topic   --bootstrap-server broker-1:19092"

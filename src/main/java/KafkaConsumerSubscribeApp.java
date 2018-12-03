import org.apache.kafka.clients.consumer.*;

import java.util.*;

public class KafkaConsumerSubscribeApp {

    public static void main(String[] args){

        // Create the Properties class to instantiate the Consumer with the desired settings:
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9090, localhost:9091");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("group.id", "test");



        // Create a KafkaConsumer instance and configure it with properties.
        KafkaConsumer<String, String> myConsumer = new KafkaConsumer<String, String>(props);

        // Create a topic subscription list:
        ArrayList<String> topics = new ArrayList<String>();
        topics.add("my-topic");
        topics.add("my-other-topic");
        // topics.add("myNewTopic");
        myConsumer.subscribe(topics);



        // Start polling for messages:
        try {
            while (true){
                ConsumerRecords records = myConsumer.poll(10);
                printRecords(records);
            }
        } finally {
            myConsumer.close();
        }

    }



    private static void printRecords(ConsumerRecords<String, String> records)
    {
        for (ConsumerRecord<String, String> record : records) {
            System.out.println(String.format("Topic: %s, Partition: %d, Offset: %d, Key: %s, Value: %s", record.topic(), record.partition(), record.offset(), record.key(), record.value()));
        }
    }
}

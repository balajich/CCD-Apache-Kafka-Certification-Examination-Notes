import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

public class KafkaConsumerGroupApp0 {

    public static void main(String[] args){

        // Create the Properties class to instantiate the Consumer with the desired settings:
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092, localhost:9093");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("group.id", "my-group"); // Required when subscribing to topics. Rename as desired.

        // Create a KafkaConsumer instance and configure it with properties.
        KafkaConsumer<String, String> myConsumer = new KafkaConsumer<String, String>(props);

        // Create a topic subscription list:
        ArrayList<String> topics = new ArrayList<String>();
        topics.add("demo_topic");
        // topics.add("myNewTopic");
        myConsumer.subscribe(topics);

        // Retrieves the topic subscription list from the SubscriptionState internal object:
        Set<String> subscribedTopics = myConsumer.subscription();

        // Print the topic subscription list:
        printSet(subscribedTopics);

        // Start polling for messages:
        try {
            while (true){
                ConsumerRecords records = myConsumer.poll(1000);
                printRecords(records);
            }
        } finally {
            myConsumer.close();
        }

    }

    private static void printSet(Set<String> collection){
        if (collection.isEmpty()) {
            System.out.println("I am not subscribed to anything yet...");
        }
        else {
            System.out.println("I am subscribed to the following topics:");
            for (String item : collection){
                System.out.println(item);
            }
        }
    }

    private static void printRecords(ConsumerRecords<String, String> records)
    {
        for (ConsumerRecord<String, String> record : records) {
            System.out.println(String.format("Topic: %s, Partition: %d, Offset: %d, Key: %s, Value: %s", record.topic(), record.partition(), record.offset(), record.key(), record.value()));
        }
    }
}

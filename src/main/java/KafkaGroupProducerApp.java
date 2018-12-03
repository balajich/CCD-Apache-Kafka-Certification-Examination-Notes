import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaGroupProducerApp {

    public static void main(String[] args) {

        // Create the Properties class to instantiate the Consumer with the desired settings:
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092, localhost:9093");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


        KafkaProducer<String, String> myProducer = new KafkaProducer<String, String>(props);
        for (int i = 0; i < 1000; i++) {
            ProducerRecord<String, String> myRecord = new ProducerRecord<String, String>("demo_topic", "My Message from Java Program: " + i);
            myProducer.send(myRecord);
        }
        myProducer.close();

    }
}

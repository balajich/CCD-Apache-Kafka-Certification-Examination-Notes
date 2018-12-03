import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class MyFirstProducerAppWithKey {

    public static void main(String[] args) {

        // Create the Properties class to instantiate the Consumer with the desired settings:
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092, localhost:9093");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


        KafkaProducer<String, String> myProducer = new KafkaProducer<String, String>(props);
        try {
            for (int i = 0; i < 150; i++)
                //myProducer.send(new ProducerRecord<String, String>("simple_topic_par1_rep1", String.format("Message: %s ", Integer.toString(i))));
                myProducer.send(new ProducerRecord<String, String>("demo_topic", String.format("Message: %s ", Integer.toString(i))));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myProducer.close();
        }

    }
}

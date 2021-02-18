package org.eduami.kafka.producer;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

//Fire and forgot approach
public class HelloWorldProducer {
    public static void main(String[] args) {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "broker-1:19092,broker-2:29092,broker-3:39092");
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        ProducerRecord<String, String> record = new ProducerRecord<>("hello-world-topic", null, "Hello World");
        KafkaProducer<String, String> producer = new KafkaProducer<>(kafkaProps);
        try {
            producer.send(record).get(); //send record
            producer.flush(); //flush the accumulated records
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

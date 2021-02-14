package org.eduami.kafka.producer;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;


public class HelloWorldProducerSynchronouslyRecordMetaData {
    public static void main(String[] args) {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "broker-1:19092,broker-2:29092,broker-3:39092");
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        ProducerRecord<String, String> record = new ProducerRecord<>("hello-world-topic", null, "Hello World");
        KafkaProducer<String, String> producer = new KafkaProducer<>(kafkaProps);
        try {
            RecordMetadata metadata = producer.send(record).get(); //send synchronously
            System.out.println("Topic name : "+metadata.topic());
            System.out.println("partition : "+metadata.partition());
            System.out.println("offset : "+metadata.offset());
            System.out.println("timestamp : "+metadata.timestamp());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

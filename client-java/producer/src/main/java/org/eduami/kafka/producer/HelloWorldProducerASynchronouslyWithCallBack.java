package org.eduami.kafka.producer;


import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;


public class HelloWorldProducerASynchronouslyWithCallBack {
    public static void main(String[] args) {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "broker-1:19092,broker-2:29092,broker-3:39092");
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        ProducerRecord<String, String> record = new ProducerRecord<>("hello-world-topic", null, "Hello World");
        KafkaProducer<String, String> producer = new KafkaProducer<>(kafkaProps);
        try {
            producer.send(record, new HelloWorldProducerCallback());// provide a call back object
            producer.flush();// flush the records
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

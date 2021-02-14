package org.eduami.kafka.producer;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;


public class HelloWorldProducer {
	public static void main(String[] args) {
		Properties kafkaProps = new Properties();
		kafkaProps.put("bootstrap.servers", "broker-1:19092,broker-2:29092,broker-3:39092");
		kafkaProps.put("key.serializer",    "org.apache.kafka.common.serialization.StringSerializer");
		kafkaProps.put("value.serializer",  "org.apache.kafka.common.serialization.StringSerializer");
		
		ProducerRecord<String, String> record = new ProducerRecord<>("student-topic", null, "{\"id\":1,\"name\":\"Alex\"}");
		
		try (KafkaProducer<String, String> producer = new KafkaProducer<>(kafkaProps)) {
			producer.send(record).get();         // get() will wait for a reply from Kafka and will throw an exception if the record is not sent successfully to Kafka.
		} catch (Exception e) {
			// If the producer encountered errors before sending the message to Kafka.
			e.printStackTrace();
		}
	}
}

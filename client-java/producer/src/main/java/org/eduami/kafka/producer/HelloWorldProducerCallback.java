package org.eduami.kafka.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

class HelloWorldProducerCallback implements Callback {
    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        if (e != null) {
            e.printStackTrace();
        }
        System.out.println("Topic name : " + recordMetadata.topic());
        System.out.println("partition : " + recordMetadata.partition());
        System.out.println("offset : " + recordMetadata.offset());
        System.out.println("timestamp : " + recordMetadata.timestamp());
    }

}
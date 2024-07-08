package com.example.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "test", groupId = "kafka_test")
    public void receive(String message) {
        System.out.println("Received message: " + message);
    }
}

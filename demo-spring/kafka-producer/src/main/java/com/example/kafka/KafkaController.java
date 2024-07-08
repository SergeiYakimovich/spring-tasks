package com.example.kafka;

import com.example.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaController {
    private final KafkaProducer kafkaProducer;

    @GetMapping("/")
    public ResponseEntity<String> hello(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("<i>Hello</i> <h1>World!</h1>");
    }

    @GetMapping("/kafka")
    public String kafka(@RequestParam String message) {
        kafkaProducer.sendMessage("Hello Kafka : " + message);
        return "Success";
    }
}

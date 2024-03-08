package com.example.springbootkafka.controller;

import com.example.springbootkafka.kafka.KafkaProducerJson;
import com.example.springbootkafka.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class JsonMessageController {

    private KafkaProducerJson kafkaProducer;

    public JsonMessageController(KafkaProducerJson kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    //@request body to automatically convert json into java object
    public ResponseEntity<String> publish(@RequestBody User user)
    {
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");

    }
}
//created simple rest endpoint which will handle http post request and it will process json object from http request

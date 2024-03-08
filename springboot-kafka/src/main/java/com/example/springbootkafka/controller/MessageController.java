package com.example.springbootkafka.controller;

import com.example.springbootkafka.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//to create rest endpoint to get message from client to producer
@RestController
@RequestMapping("/api/kafka")
public class MessageController {

    private KafkaProducer kafkaProducer; //injecting kafka producer, constructor based

    //if spring bean contains only one parameterized constructor no need to use @autowire annot
    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    //lets create a rest endpoint
    //@request param annotation to get the value from query parameter
    //http:localhost:8080/api/kafka/publish?message=hello world
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message)
    {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }
    // so we created rest endpoint that send message to kafka producer that internally uses kafka template to
    // send a message to kafka topic
}

package com.example.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//created kafka producer which will use kafka template to send message to the topic named myTopic
@Service
public class KafkaProducer {

    //logger to print the message
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    //spring boot will provide auto configuration for this kafka template so we simply inject and use it
    private KafkaTemplate<String, String> kafkaTemplate;

    // constructor based dependency injection to inject kafka template
    //if spring bean contains only one parameterized constructor no need to use @autowire annot
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    //method to use kafka template and send a message
    public void sendMessage(String message)
    {
        LOGGER.info(String.format("Message sent %s", message));
        kafkaTemplate.send("myTopic",message);

    }
}

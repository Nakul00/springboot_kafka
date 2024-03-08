package com.example.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//creating a subscriber method which will subscribe to the topic
@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "myTopic", groupId = "myGroup")  //to subscribe to the topic
    //consumer will consume the message from that topic and print to the console using log statement
    public void consume(String message)
    {
        LOGGER.info(String.format("Message received -> %s", message));
    }
}

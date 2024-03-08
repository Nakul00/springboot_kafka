package com.example.springbootkafka.kafka;

import com.example.springbootkafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerJson {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerJson.class);

    //kafka template to send json message to kafka topic
    //we are going to pass user object as a byte array to the kafka topic so using User class as a value here
    private KafkaTemplate<String, User> kafkaTemplate;

    // constructor based dependency injection to inject kafka template
    //if spring bean contains only one parameterized constructor no need to use @autowire annot
    public KafkaProducerJson(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data)
    {
        LOGGER.info(String.format("Message sent -> %s", data.toString() ));

        Message<User> message = MessageBuilder
                .withPayload(data)
                //set a topic name in header
                .setHeader(KafkaHeaders.TOPIC, "myTopic_json")
                .build();
        kafkaTemplate.send(message);
    }

}

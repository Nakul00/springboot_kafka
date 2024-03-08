package com.example.springbootkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

//@Configuration
// no need to create this topic here, already working from terminal
public class KafkaTopicConfig {

    @Bean
    public NewTopic Topic()
    {
        return TopicBuilder.name("myTopic")    // topic name- myTopic
               // .partitions(10)  - split topic into 10 partitions eg. nothing means default
                .build();
    }

    @Bean
    public NewTopic TopicJson()
    {
        return TopicBuilder.name("myTopic_json")    //topic name- myTopic
                // .partitions(10)  - split topic into 10 partitions eg. nothing means default
                .build();
    }

}

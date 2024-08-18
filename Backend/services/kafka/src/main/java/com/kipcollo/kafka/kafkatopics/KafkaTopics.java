package com.kipcollo.kafka.kafkatopics;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;


@Configuration
public class KafkaTopics {

    @Bean
    public NewTopic topics(){
        return TopicBuilder
        .name("collins")
        .build();
    }
}

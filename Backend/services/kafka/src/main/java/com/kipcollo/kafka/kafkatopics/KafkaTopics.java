package com.kipcollo.kafka.kafkatopics;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;


@Configuration
public class KafkaTopics {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Bean
    public NewTopic topics(){
        return TopicBuilder
        .name("collins")
        .build();
    }

    public void publish(){
        kafkaTemplate.send(null);
    }
}

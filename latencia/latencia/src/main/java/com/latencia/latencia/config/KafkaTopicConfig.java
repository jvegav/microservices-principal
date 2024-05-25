package com.latencia.latencia.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
@Configuration
public class KafkaTopicConfig {

    // CLASE ENCARGADA DE ADMINISTRAR LOS TOPICOS DE JKAFKA

    @Bean
    public NewTopic mensajeTopic(){
        return TopicBuilder.name("mensaje").build();
    }
    
}
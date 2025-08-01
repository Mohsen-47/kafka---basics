package com.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication(scanBasePackages = "com.kafka")

public class KafkaApplication {


    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }
//    @Bean
//    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
//        return args -> {
//            kafkaTemplate.send("buyOrder","name : mouse , stockQuantity : 3");
//        };
//    }

}

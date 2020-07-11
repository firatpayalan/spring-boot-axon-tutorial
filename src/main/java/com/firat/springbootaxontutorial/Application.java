package com.firat.springbootaxontutorial;

import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;
import org.axonframework.springboot.autoconfig.AxonServerAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EnableAutoConfiguration(exclude = AxonServerAutoConfiguration.class)
    @Configuration
    static class DisableAxonConfigServer{

        @Bean
        public EventStorageEngine eventStorageEngine(){
            return new InMemoryEventStorageEngine();
        }

    }

}

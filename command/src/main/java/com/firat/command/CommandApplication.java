package com.firat.command;

import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;
import org.axonframework.springboot.autoconfig.AxonServerAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class CommandApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandApplication.class, args);
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

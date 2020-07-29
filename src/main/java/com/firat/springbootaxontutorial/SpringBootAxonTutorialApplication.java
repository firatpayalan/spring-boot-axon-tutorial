package com.firat.springbootaxontutorial;

import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;
import org.axonframework.springboot.autoconfig.AxonServerAutoConfiguration;
import org.springframework.amqp.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SpringBootAxonTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAxonTutorialApplication.class, args);
    }

    @EnableAutoConfiguration(exclude = AxonServerAutoConfiguration.class)
    @Configuration
    static class DisableAxonConfigServer{

        @Bean
        public EventStorageEngine eventStorageEngine(){
            return new InMemoryEventStorageEngine();
        }
    }

    @Configuration
    static class RabbitInitializer{
        public static final String QUEUE_NAME = "wallet.events.queue";
        public static final String EXCHANGE_NAME = "wallet.events";
        @Bean
        public Queue queue() {
            return new Queue(QUEUE_NAME, false);
        }

        @Bean
        public FanoutExchange exchange() {
            return new FanoutExchange(EXCHANGE_NAME);
        }

        @Bean
        Binding binding(Queue queue, FanoutExchange exchange) {
            return BindingBuilder.bind(queue).to(exchange);
        }

    }

}

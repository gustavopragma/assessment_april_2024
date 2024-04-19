package com.gustavo.pinto.ticketservice.infrastructure.rabbitmq;

import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    private final AmqpAdmin rabbitAdmin;

    public RabbitConfig(AmqpAdmin rabbitAdmin) {
        this.rabbitAdmin = rabbitAdmin;
    }

    @PostConstruct
    public void declareQueue() {
        Queue participantQueue = new Queue("q.participant.notifications");
        Queue spectatorQueue = new Queue("q.spectator.notifications");
        DirectExchange directExchange = new DirectExchange("x.notifications");
        Binding participantBinding = BindingBuilder
                .bind(participantQueue)
                .to(directExchange)
                .with("b.participant.notifications");
        Binding spectatorBinding = BindingBuilder
                .bind(spectatorQueue)
                .to(directExchange)
                .with("b.spectator.notifications");
        rabbitAdmin.declareQueue(participantQueue);
        rabbitAdmin.declareQueue(spectatorQueue);
        rabbitAdmin.declareExchange(directExchange);
        rabbitAdmin.declareBinding(participantBinding);
        rabbitAdmin.declareBinding(spectatorBinding);
    }
}

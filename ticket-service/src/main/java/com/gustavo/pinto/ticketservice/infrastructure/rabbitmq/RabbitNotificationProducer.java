package com.gustavo.pinto.ticketservice.infrastructure.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.gustavo.pinto.ticketservice.application.dtos.NotificationDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RabbitNotificationProducer {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper = JsonMapper.builder()
            .findAndAddModules()
            .build();

    public RabbitNotificationProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendParticipantNotification(NotificationDTO notificationDTO) {
        try {
            String json = objectMapper.writeValueAsString(notificationDTO);
            rabbitTemplate.convertAndSend("x.notifications", "b.participant.notifications", json);
        } catch (JsonProcessingException ex) {
            System.out.println("Error parsing JSON");
        }
    }

    public void sendSpectatorNotification(NotificationDTO notificationDTO) {
        try {
            String json = objectMapper.writeValueAsString(notificationDTO);
            rabbitTemplate.convertAndSend("x.notifications", "b.spectator.notifications", json);
        } catch (JsonProcessingException ex) {
            System.out.println("Error parsing JSON");
        }
    }
}

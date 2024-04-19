package com.gustavo.pinto.notificationservice.infrastructure.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.gustavo.pinto.notificationservice.domain.models.Notification;
import com.gustavo.pinto.notificationservice.domain.repositories.NotificationRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitConsumer {
    private final NotificationRepository notificationRepository;
    private final ObjectMapper objectMapper = JsonMapper.builder()
            .findAndAddModules()
            .build();

    public RabbitConsumer(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @RabbitListener(queues = "q.participant.notifications")
    public void listenParticipantNotification(String message) {
        try {
            Notification notification = objectMapper.readValue(message, Notification.class);
            String id = notificationRepository.createNotification(notification);
            notification.setId(id);
            System.out.println(notification);
        } catch (JsonProcessingException ex) {
            System.out.println("Error deserializing json string");
        }
    }

    @RabbitListener(queues = "q.spectator.notifications")
    public void listenSpectatorNotification(String message) {
        try {
            Notification notification = objectMapper.readValue(message, Notification.class);
            String id = notificationRepository.createNotification(notification);
            notification.setId(id);
            System.out.println(notification);
        } catch (JsonProcessingException ex) {
            System.out.println("Error deserializing json string");
        }
    }
}

package com.gustavo.pinto.notificationservice.infrastructure.mappers;

import com.gustavo.pinto.notificationservice.domain.models.Notification;
import com.gustavo.pinto.notificationservice.infrastructure.entities.NotificationEntity;

public class NotificationEntityMapper {
    public static Notification toModel(NotificationEntity notificationEntity) {
        Notification notification = new Notification();
        notification.setId(notificationEntity.getId());
        notification.setPrice(notificationEntity.getPrice());
        notification.setCreatedAt(notificationEntity.getCreatedAt());
        notification.setTicketId(notificationEntity.getTicketId());
        notification.setTicketType(notificationEntity.getTicketType());
        notification.setTournamentId(notificationEntity.getTournamentId());
        return notification;
    }

    public static NotificationEntity toEntity(Notification notification) {
        return NotificationEntity.builder()
                .id(notification.getId())
                .price(notification.getPrice())
                .createdAt(notification.getCreatedAt())
                .ticketId(notification.getTicketId())
                .ticketType(notification.getTicketType())
                .tournamentId(notification.getTournamentId())
                .build();
    }
}

package com.gustavo.pinto.notificationservice.application.mappers;

import com.gustavo.pinto.notificationservice.application.dtos.NotificationResponseDTO;
import com.gustavo.pinto.notificationservice.domain.models.Notification;

public class NotificationResponseDTOMapper {
    public static NotificationResponseDTO toDTO(Notification notification) {
        return NotificationResponseDTO.builder()
                .id(notification.getId())
                .ticketType(notification.getTicketType())
                .price(notification.getPrice())
                .ticketId(notification.getTicketId())
                .tournamentId(notification.getTournamentId())
                .createdAt(notification.getCreatedAt())
                .build();
    }
}

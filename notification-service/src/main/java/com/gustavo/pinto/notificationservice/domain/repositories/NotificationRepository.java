package com.gustavo.pinto.notificationservice.domain.repositories;

import com.gustavo.pinto.notificationservice.domain.models.Notification;

import java.util.List;

public interface NotificationRepository {
    List<Notification> getNotificationsByTournamentIdAndTicketType(String tournamentId, String ticketType);
    String createNotification(Notification notification);
}

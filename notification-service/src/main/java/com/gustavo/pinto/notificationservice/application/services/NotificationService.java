package com.gustavo.pinto.notificationservice.application.services;

import com.gustavo.pinto.notificationservice.application.dtos.NotificationResponseDTO;
import com.gustavo.pinto.notificationservice.application.mappers.NotificationResponseDTOMapper;
import com.gustavo.pinto.notificationservice.domain.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<NotificationResponseDTO> getNotificationsByTournamentIdAndTicketType(String tournamentId, String ticketType) {
        return notificationRepository
                .getNotificationsByTournamentIdAndTicketType(tournamentId, ticketType)
                .stream()
                .map(NotificationResponseDTOMapper::toDTO)
                .toList();
    }
}

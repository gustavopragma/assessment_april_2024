package com.gustavo.pinto.notificationservice.infrastructure.controllers;

import com.gustavo.pinto.notificationservice.application.dtos.NotificationResponseDTO;
import com.gustavo.pinto.notificationservice.application.services.NotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("")
    public List<NotificationResponseDTO> getNotificationsByTournamentIdAndTicketType(
            @RequestParam String tournamentId,
            @RequestParam String ticketType
    ) {
        return notificationService.getNotificationsByTournamentIdAndTicketType(tournamentId, ticketType);
    }
}

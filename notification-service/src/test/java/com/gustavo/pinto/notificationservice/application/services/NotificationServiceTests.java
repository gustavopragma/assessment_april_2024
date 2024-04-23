package com.gustavo.pinto.notificationservice.application.services;

import com.gustavo.pinto.notificationservice.domain.repositories.NotificationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NotificationServiceTests {
    @Mock
    private NotificationRepository notificationRepository;
    @InjectMocks
    private NotificationService notificationService;

    @Test
    public void testGetNotificationsByTournamentIdAndTicketTypeSuccessfully() {
        //When
        notificationService.getNotificationsByTournamentIdAndTicketType("1","participant");
        //Then
        Mockito.verify(notificationRepository, Mockito.times(1)).getNotificationsByTournamentIdAndTicketType("1", "participant");
    }
}

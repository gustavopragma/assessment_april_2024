package com.gustavo.pinto.ticketservice.application.services;

import com.gustavo.pinto.ticketservice.application.dtos.NotificationDTO;
import com.gustavo.pinto.ticketservice.domain.exceptions.NotFoundException;
import com.gustavo.pinto.ticketservice.domain.models.SpectatorTicket;
import com.gustavo.pinto.ticketservice.domain.repositories.SpectatorTicketRepository;
import com.gustavo.pinto.ticketservice.infrastructure.rabbitmq.RabbitNotificationProducer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
public class SpectatorTicketServiceTests {
    @Mock
    private SpectatorTicketRepository spectatorTicketRepository;
    @Mock
    private RabbitNotificationProducer rabbitNotificationProducer;

    @InjectMocks
    private SpectatorTicketService spectatorTicketService;

    @Test
    public void testCreateSpectatorTicketSuccessfully() {
        //When
        spectatorTicketService.createSpectatortTicket(SpectatorTicketData.createSpectatorTicketDTO);
        //Then
        Mockito.verify(spectatorTicketRepository, Mockito.times(1)).createSpectatorTicket(Mockito.any(SpectatorTicket.class));
        Mockito.verify(rabbitNotificationProducer, Mockito.times(1)).sendSpectatorNotification(Mockito.any(NotificationDTO.class));
        Mockito.verify(rabbitNotificationProducer, Mockito.never()).sendParticipantNotification(Mockito.any(NotificationDTO.class));
    }

    @Test
    public void testGetSpectatorTicketByIdIfSpectatorTicketNotExists() {
        //Given
        Mockito.when(spectatorTicketRepository.getSpectatorTicketById("1")).thenReturn(Optional.empty());
        //When
        assertThatThrownBy(() -> {
            spectatorTicketService.getSpectatorTicketById("1");
        }).isInstanceOf(NotFoundException.class);
        //Then
        Mockito.verify(spectatorTicketRepository, Mockito.times(1)).getSpectatorTicketById("1");
    }

    @Test
    public void testGetSpectatorTicketByIdSuccessfully() {
        //Given
        Mockito.when(spectatorTicketRepository.getSpectatorTicketById("1")).thenReturn(Optional.of(SpectatorTicketData.createSpectatorTicket()));
        //When
        spectatorTicketService.getSpectatorTicketById("1");
        //Then
        Mockito.verify(spectatorTicketRepository, Mockito.times(1)).getSpectatorTicketById("1");
    }

    @Test
    public void testGetTotalSpectatorSalesSuccessfully() {
        //When
        spectatorTicketService.getTotalSpectatorSales("1");
        //Then
        Mockito.verify(spectatorTicketRepository, Mockito.times(1)).getTotalSpectatorSales("1");
    }

    @Test
    public void testGetTotalParticipantsSuccessfully() {
        //When
        spectatorTicketService.getTotalSpectators("1");
        //Then
        Mockito.verify(spectatorTicketRepository, Mockito.times(1)).getTotalSpectators("1");
    }
}

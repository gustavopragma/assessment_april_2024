package com.gustavo.pinto.ticketservice.application.services;

import com.gustavo.pinto.ticketservice.application.dtos.NotificationDTO;
import com.gustavo.pinto.ticketservice.domain.exceptions.NotFoundException;
import com.gustavo.pinto.ticketservice.domain.models.ParticipantTicket;
import com.gustavo.pinto.ticketservice.domain.repositories.ParticipantTicketRepository;
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
public class ParticipantTicketServiceTests {
    @Mock
    private ParticipantTicketRepository participantTicketRepository;
    @Mock
    private RabbitNotificationProducer rabbitNotificationProducer;

    @InjectMocks
    private ParticipantTicketService participantTicketService;

    @Test
    public void testCreateParticipantTicketSuccessfully() {
        //When
        participantTicketService.createParticipantTicket(ParticipantTicketData.createParticipantTicketDTO);
        //Then
        Mockito.verify(participantTicketRepository, Mockito.times(1)).createParticipantTicket(Mockito.any(ParticipantTicket.class));
        Mockito.verify(rabbitNotificationProducer, Mockito.times(1)).sendParticipantNotification(Mockito.any(NotificationDTO.class));
        Mockito.verify(rabbitNotificationProducer, Mockito.never()).sendSpectatorNotification(Mockito.any(NotificationDTO.class));
    }

    @Test
    public void testGetParticipantTicketByIdIfParticipantTicketNotExists() {
        //Given
        Mockito.when(participantTicketRepository.getParticipantTicketById("1")).thenReturn(Optional.empty());
        //When
        assertThatThrownBy(() -> {
            participantTicketService.getParticipantTicketById("1");
        }).isInstanceOf(NotFoundException.class);
        //Then
        Mockito.verify(participantTicketRepository, Mockito.times(1)).getParticipantTicketById("1");
    }

    @Test
    public void testGetParticipantTicketByIdSuccessfully() {
        //Given
        Mockito.when(participantTicketRepository.getParticipantTicketById("1")).thenReturn(Optional.of(ParticipantTicketData.createParticipantTicket()));
        //When
        participantTicketService.getParticipantTicketById("1");
        //Then
        Mockito.verify(participantTicketRepository, Mockito.times(1)).getParticipantTicketById("1");
    }

    @Test
    public void testGetTotalParticipantSalesSuccessfully() {
        //When
        participantTicketService.getTotalParticipantSales("1");
        //Then
        Mockito.verify(participantTicketRepository, Mockito.times(1)).getTotalParticipantSales("1");
    }

    @Test
    public void testGetTotalParticipantsSuccessfully() {
        //When
        participantTicketService.getTotalParticipants("1");
        //Then
        Mockito.verify(participantTicketRepository, Mockito.times(1)).getTotalParticipants("1");
    }
}

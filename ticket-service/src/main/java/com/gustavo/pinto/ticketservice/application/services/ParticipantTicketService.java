package com.gustavo.pinto.ticketservice.application.services;

import com.gustavo.pinto.ticketservice.application.dtos.*;
import com.gustavo.pinto.ticketservice.application.mappers.CreateParticipantTicketDTOMapper;
import com.gustavo.pinto.ticketservice.application.mappers.ParticipantTicketResponseDTOMapper;
import com.gustavo.pinto.ticketservice.domain.exceptions.NotFoundException;
import com.gustavo.pinto.ticketservice.domain.models.ParticipantTicket;
import com.gustavo.pinto.ticketservice.domain.repositories.ParticipantTicketRepository;
import com.gustavo.pinto.ticketservice.infrastructure.rabbitmq.RabbitNotificationProducer;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ParticipantTicketService {
    private final ParticipantTicketRepository participantTicketRepository;
    private final RabbitNotificationProducer rabbitNotificationProducer;

    public ParticipantTicketService(ParticipantTicketRepository participantTicketRepository, RabbitNotificationProducer rabbitNotificationProducer) {
        this.participantTicketRepository = participantTicketRepository;
        this.rabbitNotificationProducer = rabbitNotificationProducer;
    }

    public CreateParticipantTicketResponseDTO createParticipantTicket(CreateParticipantTicketDTO createParticipantTicketDTO) {
        ParticipantTicket participantTicket = CreateParticipantTicketDTOMapper.toModel(createParticipantTicketDTO);
        participantTicket.setCreatedAt(LocalDate.now());
        participantTicket.setActivate(true);
        String id = participantTicketRepository.createParticipantTicket(participantTicket);
        NotificationDTO notificationDTO = NotificationDTO.builder()
                .ticketId(id)
                .ticketType("participant")
                .tournamentId(participantTicket.getTournamentId())
                .price(participantTicket.getPrice())
                .createdAt(participantTicket.getCreatedAt())
                .build();
        rabbitNotificationProducer.sendParticipantNotification(notificationDTO);
        return CreateParticipantTicketResponseDTO.builder()
                .id(id)
                .build();
    }

    public ParticipantTicketResponseDTO getParticipantTicketById(String id) {
        Optional<ParticipantTicket> optionalParticipantTicket = participantTicketRepository.getParticipantTicketById(id);
        if(optionalParticipantTicket.isEmpty()) throw new NotFoundException("Ticket not found");
        return ParticipantTicketResponseDTOMapper.toDTO(optionalParticipantTicket.get());
    }

    public TotalSalesDTO getTotalParticipantSales(String tournamentId) {
        Float totalSales = participantTicketRepository.getTotalParticipantSales(tournamentId);
        return TotalSalesDTO.builder()
                .totalSales(totalSales)
                .build();
    }

    public TotalParticipantsDTO getTotalParticipants(String tournamentId) {
        Integer totalParticipants = participantTicketRepository.getTotalParticipants(tournamentId);
        return TotalParticipantsDTO.builder()
                .totalParticipants(totalParticipants)
                .build();
    }
}

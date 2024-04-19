package com.gustavo.pinto.ticketservice.application.services;

import com.gustavo.pinto.ticketservice.application.dtos.*;
import com.gustavo.pinto.ticketservice.application.mappers.CreateSpectatorTicketDTOMapper;
import com.gustavo.pinto.ticketservice.application.mappers.SpectatorTicketResponseDTOMapper;
import com.gustavo.pinto.ticketservice.domain.exceptions.NotFoundException;
import com.gustavo.pinto.ticketservice.domain.models.SpectatorTicket;
import com.gustavo.pinto.ticketservice.domain.repositories.SpectatorTicketRepository;
import com.gustavo.pinto.ticketservice.infrastructure.rabbitmq.RabbitNotificationProducer;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class SpectatorTicketService {
    private final RabbitNotificationProducer rabbitNotificationProducer;
    private final SpectatorTicketRepository spectatorTicketRepository;

    public SpectatorTicketService(RabbitNotificationProducer rabbitNotificationProducer, SpectatorTicketRepository spectatorTicketRepository) {
        this.rabbitNotificationProducer = rabbitNotificationProducer;
        this.spectatorTicketRepository = spectatorTicketRepository;
    }

    public CreateSpectatorTicketResponseDTO createSpectatortTicket(CreateSpectatorTicketDTO createSpectatorTicketDTO) {
        SpectatorTicket spectatorTicket = CreateSpectatorTicketDTOMapper.toModel(createSpectatorTicketDTO);
        spectatorTicket.setCreatedAt(LocalDate.now());
        spectatorTicket.setActivate(true);
        String id = spectatorTicketRepository.createSpectatorTicket(spectatorTicket);
        NotificationDTO notificationDTO = NotificationDTO.builder()
                .ticketId(id)
                .ticketType("spectator")
                .tournamentId(spectatorTicket.getTournamentId())
                .price(spectatorTicket.getPrice())
                .createdAt(spectatorTicket.getCreatedAt())
                .build();
        rabbitNotificationProducer.sendSpectatorNotification(notificationDTO);
        return CreateSpectatorTicketResponseDTO.builder()
                .id(id)
                .build();
    }

    public SpectatorTicketResponseDTO getSpectatorTicketById(String id) {
        Optional<SpectatorTicket> optionalSpectatorTicket = spectatorTicketRepository.getSpectatorTicketById(id);
        if(optionalSpectatorTicket.isEmpty()) throw new NotFoundException("Ticket not found");
        return SpectatorTicketResponseDTOMapper.toDTO(optionalSpectatorTicket.get());
    }

    public TotalSalesDTO getTotalSpectatorSales(String tournamentId) {
        Float totalSales = spectatorTicketRepository.getTotalSpectatorSales(tournamentId);
        return TotalSalesDTO.builder()
                .totalSales(totalSales)
                .build();
    }

    public TotalParticipantsDTO getTotalSpectators(String tournamentId) {
        Integer totalParticipants = spectatorTicketRepository.getTotalSpectators(tournamentId);
        return TotalParticipantsDTO.builder()
                .totalParticipants(totalParticipants)
                .build();
    }
}

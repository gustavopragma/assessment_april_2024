package com.gustavo.pinto.ticketservice.infrastructure.mappers;

import com.gustavo.pinto.ticketservice.domain.models.ParticipantTicket;
import com.gustavo.pinto.ticketservice.infrastructure.entities.ParticipantTicketEntity;

public class ParticipantTicketEntityMapper {
    public static ParticipantTicket toModel(ParticipantTicketEntity participantTicketEntity) {
        ParticipantTicket participantTicket = new ParticipantTicket();
        participantTicket.setId(participantTicketEntity.getId());
        participantTicket.setClientId(participantTicketEntity.getClientId());
        participantTicket.setPrice(participantTicketEntity.getPrice());
        participantTicket.setTournamentId(participantTicketEntity.getTournamentId());
        participantTicket.setActivate(participantTicketEntity.getIsActivate());
        participantTicket.setCreatedAt(participantTicketEntity.getCreatedAt());
        return participantTicket;
    }

    public static ParticipantTicketEntity toEntity(ParticipantTicket participantTicket) {
        return ParticipantTicketEntity.builder()
                .id(participantTicket.getId())
                .clientId(participantTicket.getClientId())
                .price(participantTicket.getPrice())
                .tournamentId(participantTicket.getTournamentId())
                .isActivate(participantTicket.getActivate())
                .createdAt(participantTicket.getCreatedAt())
                .build();
    }
}

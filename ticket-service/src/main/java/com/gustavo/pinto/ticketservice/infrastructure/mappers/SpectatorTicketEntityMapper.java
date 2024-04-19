package com.gustavo.pinto.ticketservice.infrastructure.mappers;

import com.gustavo.pinto.ticketservice.domain.models.SpectatorTicket;
import com.gustavo.pinto.ticketservice.infrastructure.entities.SpectatorTicketEntity;

public class SpectatorTicketEntityMapper {
    public static SpectatorTicket toModel(SpectatorTicketEntity spectatorTicketEntity) {
        SpectatorTicket spectatorTicket = new SpectatorTicket();
        spectatorTicket.setId(spectatorTicketEntity.getId());
        spectatorTicket.setPrice(spectatorTicketEntity.getPrice());
        spectatorTicket.setTournamentId(spectatorTicketEntity.getTournamentId());
        spectatorTicket.setStreamingId(spectatorTicketEntity.getStreamingId());
        spectatorTicket.setClientId(spectatorTicketEntity.getClientId());
        spectatorTicket.setActivate(spectatorTicketEntity.getIsActivate());
        spectatorTicket.setCreatedAt(spectatorTicketEntity.getCreatedAt());
        return spectatorTicket;
    }

    public static SpectatorTicketEntity toEntity(SpectatorTicket spectatorTicket) {
        return SpectatorTicketEntity.builder()
                .id(spectatorTicket.getId())
                .price(spectatorTicket.getPrice())
                .tournamentId(spectatorTicket.getTournamentId())
                .streamingId(spectatorTicket.getStreamingId())
                .clientId(spectatorTicket.getClientId())
                .isActivate(spectatorTicket.getActivate())
                .createdAt(spectatorTicket.getCreatedAt())
                .build();
    }
}

package com.gustavo.pinto.ticketservice.application.mappers;

import com.gustavo.pinto.ticketservice.application.dtos.SpectatorTicketResponseDTO;
import com.gustavo.pinto.ticketservice.domain.models.SpectatorTicket;

public class SpectatorTicketResponseDTOMapper {
    public static SpectatorTicketResponseDTO toDTO(SpectatorTicket spectatorTicket) {
        return SpectatorTicketResponseDTO.builder()
                .id(spectatorTicket.getId())
                .tournamentId(spectatorTicket.getTournamentId())
                .streamingId(spectatorTicket.getStreamingId())
                .clientId(spectatorTicket.getClientId())
                .price(spectatorTicket.getPrice())
                .createdAt(spectatorTicket.getCreatedAt())
                .build();

    }
}

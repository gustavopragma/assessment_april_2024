package com.gustavo.pinto.ticketservice.application.mappers;

import com.gustavo.pinto.ticketservice.application.dtos.ParticipantTicketResponseDTO;
import com.gustavo.pinto.ticketservice.domain.models.ParticipantTicket;

public class ParticipantTicketResponseDTOMapper {
    public static ParticipantTicketResponseDTO toDTO(ParticipantTicket participantTicket) {
        return ParticipantTicketResponseDTO.builder()
                .id(participantTicket.getId())
                .price(participantTicket.getPrice())
                .clientId(participantTicket.getClientId())
                .tournamentId(participantTicket.getTournamentId())
                .createdAt(participantTicket.getCreatedAt())
                .build();
    }
}

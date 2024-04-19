package com.gustavo.pinto.ticketservice.application.mappers;

import com.gustavo.pinto.ticketservice.application.dtos.CreateParticipantTicketDTO;
import com.gustavo.pinto.ticketservice.domain.models.ParticipantTicket;

public class CreateParticipantTicketDTOMapper {
    public static ParticipantTicket toModel(CreateParticipantTicketDTO createParticipantTicketDTO) {
        ParticipantTicket participantTicket = new ParticipantTicket();
        participantTicket.setClientId(createParticipantTicketDTO.getClientId());
        participantTicket.setTournamentId(createParticipantTicketDTO.getTournamentId());
        participantTicket.setPrice(createParticipantTicketDTO.getPrice());
        return participantTicket;
    }
}

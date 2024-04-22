package com.gustavo.pinto.ticketservice.application.services;

import com.gustavo.pinto.ticketservice.application.dtos.CreateParticipantTicketDTO;
import com.gustavo.pinto.ticketservice.domain.models.ParticipantTicket;

public class ParticipantTicketData {
    public static CreateParticipantTicketDTO createParticipantTicketDTO = CreateParticipantTicketDTO.builder()
            .clientId("1")
            .price(20000f)
            .tournamentId("1")
            .build();


    public static ParticipantTicket createParticipantTicket() {
        ParticipantTicket participantTicket = new ParticipantTicket();
        participantTicket.setTournamentId("1");
        participantTicket.setPrice(20000f);
        participantTicket.setClientId("1");
        return participantTicket;
    }
}

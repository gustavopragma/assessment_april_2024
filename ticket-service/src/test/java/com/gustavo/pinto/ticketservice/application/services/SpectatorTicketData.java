package com.gustavo.pinto.ticketservice.application.services;

import com.gustavo.pinto.ticketservice.application.dtos.CreateSpectatorTicketDTO;
import com.gustavo.pinto.ticketservice.domain.models.SpectatorTicket;

public class SpectatorTicketData {
    public static CreateSpectatorTicketDTO createSpectatorTicketDTO = CreateSpectatorTicketDTO.builder()
            .clientId("1")
            .streamingId("1")
            .price(20000f)
            .tournamentId("1")
            .build();


    public static SpectatorTicket createSpectatorTicket() {
        SpectatorTicket spectatorTicket = new SpectatorTicket();
        spectatorTicket.setTournamentId("1");
        spectatorTicket.setStreamingId("1");
        spectatorTicket.setPrice(20000f);
        spectatorTicket.setClientId("1");
        return spectatorTicket;
    }
}

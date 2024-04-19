package com.gustavo.pinto.ticketservice.application.mappers;

import com.gustavo.pinto.ticketservice.application.dtos.CreateSpectatorTicketDTO;
import com.gustavo.pinto.ticketservice.domain.models.SpectatorTicket;

public class CreateSpectatorTicketDTOMapper {
    public static SpectatorTicket toModel(CreateSpectatorTicketDTO createSpectatorTicketDTO) {
        SpectatorTicket spectatorTicket = new SpectatorTicket();
        spectatorTicket.setClientId(createSpectatorTicketDTO.getClientId());
        spectatorTicket.setStreamingId(createSpectatorTicketDTO.getStreamingId());
        spectatorTicket.setTournamentId(createSpectatorTicketDTO.getTournamentId());
        spectatorTicket.setPrice(createSpectatorTicketDTO.getPrice());
        return spectatorTicket;
    }
}

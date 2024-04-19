package com.gustavo.pinto.ticketservice.domain.repositories;

import com.gustavo.pinto.ticketservice.domain.models.SpectatorTicket;

import java.util.Optional;

public interface SpectatorTicketRepository {
    String createSpectatorTicket(SpectatorTicket spectatorTicket);
    Optional<SpectatorTicket> getSpectatorTicketById(String id);
    Float getTotalSpectatorSales(String tournamentId);
    Integer getTotalSpectators(String tournamentId);
}

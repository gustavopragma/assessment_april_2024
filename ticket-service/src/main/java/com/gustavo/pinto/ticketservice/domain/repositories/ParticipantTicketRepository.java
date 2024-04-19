package com.gustavo.pinto.ticketservice.domain.repositories;

import com.gustavo.pinto.ticketservice.domain.models.ParticipantTicket;

import java.util.List;
import java.util.Optional;

public interface ParticipantTicketRepository {
    String createParticipantTicket(ParticipantTicket participantTicket);
    Optional<ParticipantTicket> getParticipantTicketById(String id);

    Float getTotalParticipantSales(String tournamentId);

    Integer getTotalParticipants(String tournamentId);
}

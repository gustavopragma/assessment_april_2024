package com.gustavo.pinto.ticketservice.infrastructure.repositories;

import com.gustavo.pinto.ticketservice.infrastructure.entities.ParticipantTicketEntity;
import com.gustavo.pinto.ticketservice.infrastructure.entities.SpectatorTicketEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpectatorTicketEntityRepository extends MongoRepository<SpectatorTicketEntity, String> {
    List<ParticipantTicketEntity> findByTournamentId(String tournamentId);
}

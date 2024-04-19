package com.gustavo.pinto.tournamentservice.domain.repositories;

import com.gustavo.pinto.tournamentservice.domain.models.Tournament;

import java.util.List;
import java.util.Optional;

public interface TournamentRepository {
    String createTournament(Tournament tournament);
    Optional<Tournament> getTournamentById(String id);

    List<Tournament> getTournamentsByOwnerId(String ownerId);
}

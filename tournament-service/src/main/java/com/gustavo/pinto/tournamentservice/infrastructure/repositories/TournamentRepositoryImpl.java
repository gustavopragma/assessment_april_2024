package com.gustavo.pinto.tournamentservice.infrastructure.repositories;

import com.gustavo.pinto.tournamentservice.domain.models.Tournament;
import com.gustavo.pinto.tournamentservice.domain.repositories.TournamentRepository;
import com.gustavo.pinto.tournamentservice.infrastructure.entities.TournamentEntity;
import com.gustavo.pinto.tournamentservice.infrastructure.mappers.CategoryEntityMapper;
import com.gustavo.pinto.tournamentservice.infrastructure.mappers.TournamentEntityMapper;
import com.gustavo.pinto.tournamentservice.infrastructure.mappers.VideogameEntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentRepositoryImpl implements TournamentRepository {
    private final TournamentEntityRepository tournamentEntityRepository;

    public TournamentRepositoryImpl(TournamentEntityRepository tournamentEntityRepository) {
        this.tournamentEntityRepository = tournamentEntityRepository;
    }

    @Override
    public String createTournament(Tournament tournament) {
        TournamentEntity tournamentEntity = TournamentEntityMapper.toEntity(tournament);
        tournamentEntityRepository.save(tournamentEntity);
        return tournamentEntity.getId();
    }

    @Override
    public Optional<Tournament> getTournamentById(String id) {
        return tournamentEntityRepository
                .findById(id)
                .map(TournamentEntityMapper::toModel);
    }

    @Override
    public List<Tournament> getTournamentsByOwnerId(String ownerId) {
        return tournamentEntityRepository
                .findByOwnerId(ownerId)
                .stream()
                .map(TournamentEntityMapper::toModel)
                .toList();
    }

    @Override
    public Integer getTotalFreeTournaments(String ownerId) {
        return tournamentEntityRepository.findByOwnerIdAndAndCategoryEntityIsFree(ownerId, true).size();
    }
}

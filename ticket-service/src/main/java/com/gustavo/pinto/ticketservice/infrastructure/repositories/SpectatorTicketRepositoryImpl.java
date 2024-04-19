package com.gustavo.pinto.ticketservice.infrastructure.repositories;

import com.gustavo.pinto.ticketservice.domain.models.SpectatorTicket;
import com.gustavo.pinto.ticketservice.domain.repositories.SpectatorTicketRepository;
import com.gustavo.pinto.ticketservice.infrastructure.entities.ParticipantTicketEntity;
import com.gustavo.pinto.ticketservice.infrastructure.entities.SpectatorTicketEntity;
import com.gustavo.pinto.ticketservice.infrastructure.mappers.SpectatorTicketEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SpectatorTicketRepositoryImpl implements SpectatorTicketRepository {
    private final SpectatorTicketEntityRepository spectatorTicketEntityRepository;

    public SpectatorTicketRepositoryImpl(SpectatorTicketEntityRepository spectatorTicketEntityRepository) {
        this.spectatorTicketEntityRepository = spectatorTicketEntityRepository;
    }

    @Override
    public String createSpectatorTicket(SpectatorTicket spectatorTicket) {
        SpectatorTicketEntity spectatorTicketEntity = SpectatorTicketEntityMapper.toEntity(spectatorTicket);
        spectatorTicketEntityRepository.save(spectatorTicketEntity);
        return spectatorTicketEntity.getId();
    }

    @Override
    public Optional<SpectatorTicket> getSpectatorTicketById(String id) {
        return spectatorTicketEntityRepository
                .findById(id)
                .map(SpectatorTicketEntityMapper::toModel);
    }

    @Override
    public Float getTotalSpectatorSales(String tournamentId) {
        return spectatorTicketEntityRepository
                .findByTournamentId(tournamentId)
                .stream()
                .map(ParticipantTicketEntity::getPrice)
                .reduce(0f, Float::sum);
    }

    @Override
    public Integer getTotalSpectators(String tournamentId) {
        return spectatorTicketEntityRepository
                .findByTournamentId(tournamentId)
                .size();
    }
}

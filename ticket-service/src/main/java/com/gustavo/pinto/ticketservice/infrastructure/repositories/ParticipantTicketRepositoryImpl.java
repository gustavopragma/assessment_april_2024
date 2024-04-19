package com.gustavo.pinto.ticketservice.infrastructure.repositories;

import com.gustavo.pinto.ticketservice.domain.models.ParticipantTicket;
import com.gustavo.pinto.ticketservice.domain.repositories.ParticipantTicketRepository;
import com.gustavo.pinto.ticketservice.infrastructure.entities.ParticipantTicketEntity;
import com.gustavo.pinto.ticketservice.infrastructure.mappers.ParticipantTicketEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ParticipantTicketRepositoryImpl implements ParticipantTicketRepository {
    private final ParticipantTicketEntityRepository participantTicketEntityRepository;

    public ParticipantTicketRepositoryImpl(ParticipantTicketEntityRepository participantTicketEntityRepository) {
        this.participantTicketEntityRepository = participantTicketEntityRepository;
    }

    @Override
    public String createParticipantTicket(ParticipantTicket participantTicket) {
        ParticipantTicketEntity participantTicketEntity = ParticipantTicketEntityMapper.toEntity(participantTicket);
        participantTicketEntityRepository.save(participantTicketEntity);
        return participantTicketEntity.getId();
    }

    @Override
    public Optional<ParticipantTicket> getParticipantTicketById(String id) {

        return participantTicketEntityRepository
                .findById(id)
                .map(ParticipantTicketEntityMapper::toModel);
    }

    @Override
    public Float getTotalParticipantSales(String tournamentId) {
        return participantTicketEntityRepository
                .findByTournamentId(tournamentId)
                .stream()
                .map(ParticipantTicketEntity::getPrice)
                .reduce(0f, Float::sum);
    }

    @Override
    public Integer getTotalParticipants(String tournamentId) {
        return participantTicketEntityRepository
                .findByTournamentId(tournamentId)
                .size();
    }
}

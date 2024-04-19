package com.gustavo.pinto.tournamentservice.infrastructure.mappers;

import com.gustavo.pinto.tournamentservice.domain.models.Tournament;
import com.gustavo.pinto.tournamentservice.infrastructure.entities.TournamentEntity;

public class TournamentEntityMapper {
    public static TournamentEntity toEntity(Tournament tournament) {
        return TournamentEntity.builder()
                .id(tournament.getId())
                .name(tournament.getName())
                .participantsLimit(tournament.getParticipantsLimit())
                .presalePriceParticipant(tournament.getPresalePriceParticipant())
                .salePriceParticipant(tournament.getSalePriceParticipant())
                .presalePriceSpectator(tournament.getPresalePriceSpectator())
                .salePriceSpectator(tournament.getSalePriceSpectator())
                .presaleSpectatorEndDate(tournament.getPresaleSpectatorEndDate())
                .presaleParticipantEndDate(tournament.getPresaleParticipantEndDate())
                .createdAt(tournament.getCreatedAt())
                .isActivate(tournament.getActivate())
                .ownerId(tournament.getOwnerId())
                .categoryEntity(CategoryEntityMapper.toEntity(tournament.getCategory()))
                .videogameEntity(VideogameEntityMapper.toEntity(tournament.getVideogame()))
                .build();
    }

    public static Tournament toModel(TournamentEntity tournamentEntity) {
        Tournament tournament = new Tournament();
        tournament.setId(tournamentEntity.getId());
        tournament.setName(tournamentEntity.getName());
        tournament.setParticipantsLimit(tournamentEntity.getParticipantsLimit());
        tournament.setPresalePriceParticipant(tournamentEntity.getPresalePriceParticipant());
        tournament.setSalePriceParticipant(tournamentEntity.getSalePriceParticipant());
        tournament.setPresalePriceSpectator(tournamentEntity.getPresalePriceSpectator());
        tournament.setSalePriceSpectator(tournamentEntity.getSalePriceSpectator());
        tournament.setPresaleParticipantEndDate(tournamentEntity.getPresaleParticipantEndDate());
        tournament.setPresaleSpectatorEndDate(tournamentEntity.getPresaleSpectatorEndDate());
        tournament.setCreatedAt(tournamentEntity.getCreatedAt());
        tournament.setOwnerId(tournamentEntity.getOwnerId());
        tournament.setCategory(CategoryEntityMapper.toModel(tournamentEntity.getCategoryEntity()));
        tournament.setVideogame(VideogameEntityMapper.toModel(tournamentEntity.getVideogameEntity()));
        tournament.setStreamings(
                tournamentEntity
                        .getStreamingsEntity()
                        .stream()
                        .map(StreamingEntityMapper::toModel)
                        .toList()
        );
        return tournament;
    }
}

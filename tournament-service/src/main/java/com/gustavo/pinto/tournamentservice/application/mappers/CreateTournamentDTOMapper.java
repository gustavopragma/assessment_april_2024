package com.gustavo.pinto.tournamentservice.application.mappers;

import com.gustavo.pinto.tournamentservice.application.dtos.CreateTournamentDTO;
import com.gustavo.pinto.tournamentservice.domain.models.Tournament;

public class CreateTournamentDTOMapper {
    public static Tournament toModel(CreateTournamentDTO createTournamentDTO) {
        Tournament tournament = new Tournament();
        tournament.setName(createTournamentDTO.getName());
        tournament.setParticipantsLimit(createTournamentDTO.getParticipantsLimit());
        tournament.setPresalePriceParticipant(createTournamentDTO.getPresalePriceParticipant());
        tournament.setSalePriceParticipant(createTournamentDTO.getSalePriceParticipant());
        tournament.setPresalePriceSpectator(createTournamentDTO.getPresalePriceSpectator());
        tournament.setSalePriceSpectator(createTournamentDTO.getSalePriceSpectator());
        tournament.setPresaleParticipantEndDate(createTournamentDTO.getPresaleParticipantEndDate());
        tournament.setPresaleSpectatorEndDate(createTournamentDTO.getPresaleSpectatorEndDate());
        tournament.setOwnerId(createTournamentDTO.getOwnerId());
        return tournament;
    }
}

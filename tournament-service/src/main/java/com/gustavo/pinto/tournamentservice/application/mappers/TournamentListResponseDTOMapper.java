package com.gustavo.pinto.tournamentservice.application.mappers;

import com.gustavo.pinto.tournamentservice.application.dtos.TournamentListResponseDTO;
import com.gustavo.pinto.tournamentservice.domain.models.Tournament;

public class TournamentListResponseDTOMapper {
    public static TournamentListResponseDTO toDTO(Tournament tournament) {
        return TournamentListResponseDTO.builder()
                .id(tournament.getId())
                .name(tournament.getName())
                .participantsLimit(tournament.getParticipantsLimit())
                .presalePriceParticipant(tournament.getPresalePriceParticipant())
                .salePriceParticipant(tournament.getSalePriceParticipant())
                .presalePriceSpectator(tournament.getPresalePriceSpectator())
                .salePriceSpectator(tournament.getSalePriceSpectator())
                .presaleParticipantEndDate(tournament.getPresaleParticipantEndDate())
                .presaleSpectatorEndDate(tournament.getPresaleSpectatorEndDate())
                .ownerId(tournament.getOwnerId())
                .createdAt(tournament.getCreatedAt())
                .build();
    }
}

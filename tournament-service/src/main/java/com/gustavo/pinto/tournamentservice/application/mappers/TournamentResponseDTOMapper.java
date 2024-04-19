package com.gustavo.pinto.tournamentservice.application.mappers;

import com.gustavo.pinto.tournamentservice.application.dtos.TournamentResponseDTO;
import com.gustavo.pinto.tournamentservice.domain.models.Tournament;

public class TournamentResponseDTOMapper {
    public static TournamentResponseDTO toDTO(Tournament tournament) {
        return TournamentResponseDTO.builder()
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
                .videogame(VideogameResponseDTOMapper.toDTO(tournament.getVideogame()))
                .category(CategoryResponseDTOMapper.toDTO(tournament.getCategory()))
                .streamings(
                        tournament
                                .getStreamings().
                                stream()
                                .map(StreamingResponseDTOMapper::toDTO)
                                .toList()

                )
                .build();
    }
}

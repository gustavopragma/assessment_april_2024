package com.gustavo.pinto.tournamentservice.application.mappers;

import com.gustavo.pinto.tournamentservice.application.dtos.VideogameResponseDTO;
import com.gustavo.pinto.tournamentservice.domain.models.Videogame;

public class VideogameResponseDTOMapper {
    public static VideogameResponseDTO toDTO(Videogame videogame) {
        return VideogameResponseDTO.builder()
                .id(videogame.getId())
                .name(videogame.getName())
                .numberPlayers(videogame.getNumberPlayers())
                .build();
    }
}

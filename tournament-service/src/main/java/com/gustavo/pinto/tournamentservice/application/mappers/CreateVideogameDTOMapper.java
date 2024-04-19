package com.gustavo.pinto.tournamentservice.application.mappers;

import com.gustavo.pinto.tournamentservice.application.dtos.CreateVideogameDTO;
import com.gustavo.pinto.tournamentservice.domain.models.Videogame;

public class CreateVideogameDTOMapper {
    public static Videogame toModel(CreateVideogameDTO createVideogameDTO) {
        Videogame videogame = new Videogame();
        videogame.setName(createVideogameDTO.getName());
        videogame.setNumberPlayers(createVideogameDTO.getNumberPlayers());
        return videogame;
    }
}

package com.gustavo.pinto.tournamentservice.application.services;

import com.gustavo.pinto.tournamentservice.application.dtos.CreateVideogameDTO;
import com.gustavo.pinto.tournamentservice.domain.models.Videogame;

public class VideogameData {
    public static CreateVideogameDTO createVideogameDTO = CreateVideogameDTO.builder()
            .name("Videogame 1")
            .numberPlayers(2)
            .build();

    public static Videogame createVideogame() {
        Videogame videogame = new Videogame();
        videogame.setName("Videogame 1");
        videogame.setNumberPlayers(2);
        return videogame;
    }
}

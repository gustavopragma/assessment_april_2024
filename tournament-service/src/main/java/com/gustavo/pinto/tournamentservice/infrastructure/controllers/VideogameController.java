package com.gustavo.pinto.tournamentservice.infrastructure.controllers;

import com.gustavo.pinto.tournamentservice.application.dtos.CreateVideogameDTO;
import com.gustavo.pinto.tournamentservice.application.dtos.CreateVideogameResponseDTO;
import com.gustavo.pinto.tournamentservice.application.dtos.VideogameResponseDTO;
import com.gustavo.pinto.tournamentservice.application.services.VideogameService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/videogames")
public class VideogameController {
    private final VideogameService videogameService;

    public VideogameController(VideogameService videogameService) {
        this.videogameService = videogameService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<VideogameResponseDTO> getAllVideogames() {
        return videogameService.getAllVideogames();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateVideogameResponseDTO createVideogame(@RequestBody CreateVideogameDTO createVideogameDTO) {
        return videogameService.createVideogame(createVideogameDTO);
    }
}

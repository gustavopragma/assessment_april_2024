package com.gustavo.pinto.tournamentservice.infrastructure.controllers;

import com.gustavo.pinto.tournamentservice.application.dtos.CreateTournamentDTO;
import com.gustavo.pinto.tournamentservice.application.dtos.CreateTournamentResponseDTO;
import com.gustavo.pinto.tournamentservice.application.dtos.TournamentListResponseDTO;
import com.gustavo.pinto.tournamentservice.application.dtos.TournamentResponseDTO;
import com.gustavo.pinto.tournamentservice.application.services.TournamentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tournaments")
public class TournamentController {
    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping("{tournamentId}")
    public TournamentResponseDTO getTournamentById(@PathVariable String tournamentId) {
        return tournamentService.getTournamentById(tournamentId);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateTournamentResponseDTO createTournament(@RequestBody CreateTournamentDTO createTournamentDTO) {
        return tournamentService.createTournament(createTournamentDTO);
    }

    @GetMapping("/users/{ownerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<TournamentListResponseDTO> getTournamentsByOwnerId(@PathVariable String ownerId) {
        return tournamentService.getTournamentsByOwnerId(ownerId);
    }
}

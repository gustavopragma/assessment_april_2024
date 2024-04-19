package com.gustavo.pinto.ticketservice.infrastructure.controllers;

import com.gustavo.pinto.ticketservice.application.dtos.*;
import com.gustavo.pinto.ticketservice.application.services.SpectatorTicketService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/spectator-tickets")
public class SpectatorTicketController {
    private final SpectatorTicketService spectatorTicketService;

    public SpectatorTicketController(SpectatorTicketService spectatorTicketService) {
        this.spectatorTicketService = spectatorTicketService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateSpectatorTicketResponseDTO createSpectatorTicket(@RequestBody CreateSpectatorTicketDTO createSpectatorTicketDTO) {
        return spectatorTicketService.createSpectatortTicket(createSpectatorTicketDTO);
    }

    @GetMapping("/{ticketId}")
    public SpectatorTicketResponseDTO getSpectatorTicketById(@PathVariable String ticketId) {
        return spectatorTicketService.getSpectatorTicketById(ticketId);
    }

    @GetMapping("/total-sales/{tournamentId}")
    public TotalSalesDTO getTotalSpectatorSales(@PathVariable String tournamentId) {
        return spectatorTicketService.getTotalSpectatorSales(tournamentId);
    }

    @GetMapping("/total-participants/{tournamentId}")
    public TotalParticipantsDTO getTotalSpectators(@PathVariable String tournamentId) {
        return spectatorTicketService.getTotalSpectators(tournamentId);
    }
}

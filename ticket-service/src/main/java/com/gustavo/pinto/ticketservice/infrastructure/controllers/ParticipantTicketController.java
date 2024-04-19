package com.gustavo.pinto.ticketservice.infrastructure.controllers;

import com.gustavo.pinto.ticketservice.application.dtos.*;
import com.gustavo.pinto.ticketservice.application.services.ParticipantTicketService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/participant-tickets")
public class ParticipantTicketController {
    private final ParticipantTicketService participantTicketService;

    public ParticipantTicketController(ParticipantTicketService participantTicketService) {
        this.participantTicketService = participantTicketService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateParticipantTicketResponseDTO createTicket(@RequestBody CreateParticipantTicketDTO createParticipantTicketDTO) {
        return participantTicketService.createParticipantTicket(createParticipantTicketDTO);
    }


    @GetMapping("/{ticketId}")
    public ParticipantTicketResponseDTO getParticipantTicketById(@PathVariable String ticketId) {
        return participantTicketService.getParticipantTicketById(ticketId);
    }

    @GetMapping("/total-sales/{tournamentId}")
    public TotalSalesDTO getTotalParticipantSales(@PathVariable String tournamentId) {
        return participantTicketService.getTotalParticipantSales(tournamentId);
    }

    @GetMapping("/total-participants/{tournamentId}")
    public TotalParticipantsDTO getTotalParticipants(@PathVariable String tournamentId) {
        return participantTicketService.getTotalParticipants(tournamentId);
    }
}

package com.gustavo.pinto.ticketservice.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParticipantTicketResponseDTO {
    private String id;
    private String tournamentId;
    private String clientId;
    private Float price;
    private LocalDate createdAt;
}

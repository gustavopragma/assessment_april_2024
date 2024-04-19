package com.gustavo.pinto.ticketservice.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateSpectatorTicketDTO {
    private String tournamentId;
    private String streamingId;
    private String clientId;
    private Float price;
}

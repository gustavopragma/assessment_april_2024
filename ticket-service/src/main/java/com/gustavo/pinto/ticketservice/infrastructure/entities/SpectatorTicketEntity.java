package com.gustavo.pinto.ticketservice.infrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "spectator_tickets")
public class SpectatorTicketEntity {
    @Id
    private String id;
    private String tournamentId;
    private String streamingId;
    private String clientId;
    private Float price;
    private Boolean isActivate;
    private LocalDate createdAt;
}

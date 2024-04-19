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
@Document(collection = "participant_tickets")
public class ParticipantTicketEntity {
    @Id
    private String id;
    private String tournamentId;
    private String clientId;
    private Float price;
    private Boolean isActivate;
    private LocalDate createdAt;
}

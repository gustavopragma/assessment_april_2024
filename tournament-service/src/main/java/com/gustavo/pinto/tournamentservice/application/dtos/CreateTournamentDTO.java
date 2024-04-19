package com.gustavo.pinto.tournamentservice.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTournamentDTO {
    private String name;
    private Integer participantsLimit;
    private Float presalePriceParticipant;
    private Float salePriceParticipant;
    private Float presalePriceSpectator;
    private Float salePriceSpectator;
    private LocalDate presaleParticipantEndDate;
    private LocalDate presaleSpectatorEndDate;
    private String ownerId;
    private String videogameId;
    private String categoryId;
}

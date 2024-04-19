package com.gustavo.pinto.tournamentservice.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TournamentResponseDTO {
    private String id;
    private String name;
    private Integer participantsLimit;
    private Float presalePriceParticipant;
    private Float salePriceParticipant;
    private Float presalePriceSpectator;
    private Float salePriceSpectator;
    private LocalDate presaleParticipantEndDate;
    private LocalDate presaleSpectatorEndDate;
    private LocalDate createdAt;
    private String ownerId;
    private VideogameResponseDTO videogame;
    private CategoryResponseDTO category;
    private List<StreamingResponseDTO> streamings;
}

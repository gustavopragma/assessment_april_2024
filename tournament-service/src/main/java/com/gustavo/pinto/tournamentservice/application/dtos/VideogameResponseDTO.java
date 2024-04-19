package com.gustavo.pinto.tournamentservice.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideogameResponseDTO {
    private String id;
    private String name;
    private Integer numberPlayers;
}
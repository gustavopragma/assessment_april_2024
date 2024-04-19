package com.gustavo.pinto.tournamentservice.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCategoryDTO {
    private String name;
    private Boolean isFree;
    private Integer participantsLimit;
    private Integer spectatorsLimit;
    private Integer streamingLimit;
    private Integer commissionPercentage;
}

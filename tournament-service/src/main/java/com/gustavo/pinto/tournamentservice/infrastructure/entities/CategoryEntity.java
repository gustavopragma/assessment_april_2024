package com.gustavo.pinto.tournamentservice.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Boolean isFree;
    private Integer participantLimit;
    private Integer spectatorsLimit;
    private Integer streamingLimit;
    private Integer commissionPercentage;
    private Boolean isActivate;
}

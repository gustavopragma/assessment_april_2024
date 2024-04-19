package com.gustavo.pinto.tournamentservice.infrastructure.entities;

import jakarta.persistence.*;
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
@Entity
public class TournamentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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
    private Boolean isActivate;
    private String ownerId;
    @ManyToOne
    @JoinColumn(
            name = "videogameId",
            referencedColumnName = "id"
    )
    private VideogameEntity videogameEntity;
    @ManyToOne
    @JoinColumn(
            name = "categoryId",
            referencedColumnName = "id"
    )
    private CategoryEntity categoryEntity;

    @OneToMany
    @JoinColumn(name = "tournamentId")
    private List<StreamingEntity> streamingsEntity;
}

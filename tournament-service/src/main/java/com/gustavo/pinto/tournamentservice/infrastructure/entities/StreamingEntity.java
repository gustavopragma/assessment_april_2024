package com.gustavo.pinto.tournamentservice.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class StreamingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String platform;
    private String url;
    private Boolean isActivate;
    @ManyToOne
    @JoinColumn(
            name = "tournamentId",
            referencedColumnName = "id"
    )
    private TournamentEntity tournamentEntity;
}

package com.gustavo.pinto.tournamentservice.application.services;

import com.gustavo.pinto.tournamentservice.application.dtos.CreateTournamentDTO;
import com.gustavo.pinto.tournamentservice.domain.models.Tournament;

import java.time.LocalDate;
import java.util.List;

public class TournamentData {
    public static CreateTournamentDTO createTournamentDTO = CreateTournamentDTO.builder()
            .name("Tournament 1")
            .categoryId("1")
            .participantsLimit(20)
            .presaleParticipantEndDate(LocalDate.of(2024, 5, 1))
            .presalePriceParticipant(20000f)
            .presalePriceSpectator(15000f)
            .salePriceParticipant(25000f)
            .salePriceSpectator(20000f)
            .ownerId("123")
            .videogameId("1")
            .presaleSpectatorEndDate(LocalDate.of(2024, 5, 1))
            .build();

    public static Tournament createTournament() {
        Tournament tournament = new Tournament();
        tournament.setName("Tournament 1");
        tournament.setOwnerId("123");
        tournament.setCategory(CategoryData.createCategory());
        tournament.setVideogame(VideogameData.createVideogame());
        tournament.setStreamings(List.of(StreamingData.createStreaming()));
        return tournament;
    }
}

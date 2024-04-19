package com.gustavo.pinto.tournamentservice.application.dtos;

import com.gustavo.pinto.tournamentservice.domain.models.Tournament;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateStreamingDTO {
    private String platform;
    private String url;
    private String tournamentId;
}

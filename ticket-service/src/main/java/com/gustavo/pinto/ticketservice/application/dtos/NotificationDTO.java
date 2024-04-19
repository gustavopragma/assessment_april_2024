package com.gustavo.pinto.ticketservice.application.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationDTO {
    private String ticketId;
    private String ticketType;
    private String tournamentId;
    private Float price;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate createdAt;
}

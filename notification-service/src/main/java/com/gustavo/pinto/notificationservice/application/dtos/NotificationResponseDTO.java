package com.gustavo.pinto.notificationservice.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationResponseDTO {
    private String id;
    private String ticketId;
    private String ticketType;
    private String tournamentId;
    private Float price;
    private LocalDate createdAt;
}

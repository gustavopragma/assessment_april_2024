package com.gustavo.pinto.notificationservice.infrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "notifications")
public class NotificationEntity {
    @Id
    private String id;
    private String ticketId;
    private String ticketType;
    private String tournamentId;
    private Float price;
    private LocalDate createdAt;
}

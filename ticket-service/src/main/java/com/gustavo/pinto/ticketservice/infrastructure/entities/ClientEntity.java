package com.gustavo.pinto.ticketservice.infrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "clients")
public class ClientEntity {
    @Id
    private String documentNumber;
    private String email;
    private String name;
    private Boolean isActivate;
}

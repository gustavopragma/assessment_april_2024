package com.gustavo.pinto.ticketservice.infrastructure.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwkDTO {
    private String kid;
    private String kty;
    private String n;
    private String e;
}

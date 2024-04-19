package com.gustavo.pinto.middlewareservice.application.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenResponseDTO {
    @Getter(onMethod=@__({@JsonProperty("Token")}))
    @Setter(onMethod=@__({@JsonProperty("token")}))
    private String token;
}

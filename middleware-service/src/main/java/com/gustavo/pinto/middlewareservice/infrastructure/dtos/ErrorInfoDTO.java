package com.gustavo.pinto.middlewareservice.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorInfoDTO {
    @Getter(onMethod=@__({@JsonProperty("Message")}))
    @Setter(onMethod=@__({@JsonProperty("message")}))
    private String message;
}

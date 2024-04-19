package com.gustavo.pinto.middlewareservice.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponseDTO {
    @Getter(onMethod=@__({@JsonProperty("StatusCode")}))
    @Setter(onMethod=@__({@JsonProperty("statusCode")}))
    private String statusCode;
    @Getter(onMethod=@__({@JsonProperty("Errors")}))
    @Setter(onMethod=@__({@JsonProperty("errors")}))
    private List<ErrorInfoDTO> errors;
}

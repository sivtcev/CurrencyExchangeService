package com.sivtcev.exchange.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExchangeResponse {

    @JsonProperty(value = "request_id")
    private long id;
    private long amount;
}

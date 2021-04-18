package com.sivtcev.exchange.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrencyResponse {

    private String from;
    private String to;
    @JsonProperty(value = "total_sum")
    private long totalSum;


}

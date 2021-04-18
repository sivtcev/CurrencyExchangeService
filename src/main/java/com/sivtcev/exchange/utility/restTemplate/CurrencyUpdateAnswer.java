package com.sivtcev.exchange.utility.restTemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sivtcev.exchange.entity.Currency;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyUpdateAnswer {

    private String result;
    private String documentation;
    @JsonProperty(value="terms_of_use")
    private String termsOfUse;
    @JsonProperty(value="time_last_update_unix")
    private long timeLastUpdateUnix;
    @JsonProperty(value="time_last_update_utc")
    private LocalDateTime timeLastUpdateUtc;
    @JsonProperty(value="time_next_update_unix")
    private long timeNextUpdateUnix;
    @JsonProperty(value="time_next_update_utc")
    private LocalDateTime timeNextUpdateUtc;
    @JsonProperty(value="base_code")
    private String baseCode;
    @JsonProperty(value="conversion_rates")
    private List<Currency> conversionRates;
}

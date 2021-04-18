package com.sivtcev.exchange.utility.restTemplate;

import lombok.Data;
import org.springframework.web.client.RestTemplate;

@Data
public class CurrencyUpdater {
    final private RestTemplate restTemplate = new RestTemplate();
    final private String requestAddress = "https://v6.exchangerate-api.com/v6/9a875d46835769e80168aed5/latest/USD";

    public CurrencyUpdateAnswer getUpdate() {
        return restTemplate.getForObject(requestAddress, CurrencyUpdateAnswer.class);
    }
}

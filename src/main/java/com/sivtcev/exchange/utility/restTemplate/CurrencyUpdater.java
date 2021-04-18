package com.sivtcev.exchange.utility.restTemplate;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Data
public class CurrencyUpdater {
    final private RestTemplate restTemplate = new RestTemplate();
    final private String requestAddress = "https://v6.exchangerate-api.com/v6/9a875d46835769e80168aed5/latest/USD";

    public CurrencyUpdateAnswer getUpdate() {
        log.debug("Get currency update request");
        return restTemplate.getForObject(requestAddress, CurrencyUpdateAnswer.class);
    }
}

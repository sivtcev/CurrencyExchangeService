package com.sivtcev.exchange.service;

import com.sivtcev.exchange.api.request.ExchangeRequest;
import com.sivtcev.exchange.api.response.ExchangeResponse;

public interface ExchangeService {

    ExchangeResponse currencyExchange(ExchangeRequest exchangeRequest);
}

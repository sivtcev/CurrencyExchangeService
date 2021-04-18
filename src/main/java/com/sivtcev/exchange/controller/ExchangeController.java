package com.sivtcev.exchange.controller;

import com.sivtcev.exchange.api.request.ExchangeRequest;
import com.sivtcev.exchange.api.response.ExchangeResponse;
import com.sivtcev.exchange.service.ExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchange")
@AllArgsConstructor
public class ExchangeController {

    private final ExchangeService exchangeService;

    @GetMapping
    public ResponseEntity<ExchangeResponse> currencyExchange(@RequestBody ExchangeRequest exchangeRequest) {
        ExchangeResponse exchangeResponse = exchangeService.currencyExchange(exchangeRequest);
        return ResponseEntity.ok(exchangeResponse);
    }
}

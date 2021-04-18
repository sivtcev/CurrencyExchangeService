package com.sivtcev.exchange.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CurrencyListResponse {

    List<CurrencyResponse> currencies;
}

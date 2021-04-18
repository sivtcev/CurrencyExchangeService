package com.sivtcev.exchange.service;

import com.sivtcev.exchange.api.request.ExchangeRequest;
import com.sivtcev.exchange.api.response.ExchangeResponse;
import com.sivtcev.exchange.entity.Currency;
import com.sivtcev.exchange.entity.ExchangeOperation;
import com.sivtcev.exchange.entity.User;
import com.sivtcev.exchange.repository.CurrencyRepository;
import com.sivtcev.exchange.repository.ExchangeOperationRepository;
import com.sivtcev.exchange.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {

    private final CurrencyRepository currencyRepository;
    private final ExchangeOperationRepository exchangeOperationRepository;
    private final UserRepository userRepository;

    private final CurrencyService currencyService;

    @Override
    public ExchangeResponse currencyExchange(ExchangeRequest exchangeRequest) {
        User user = userRepository.getOne(exchangeRequest.getId());
        String from = exchangeRequest.getCurrencyFrom();
        String to = exchangeRequest.getCurrencyTo();
        currencyService.checkCurrencyUpdate(from, to);

        Currency currencyFrom = currencyRepository.findByName(from);
        Currency currencyTo = currencyRepository.findByName(to);

        List<BigDecimal> exchangeList = exchangedAmount(
                currencyFrom.getAmountInUSD(),
                currencyTo.getAmountInUSD(),
                exchangeRequest.getAmount()
        );

        ExchangeOperation exchangeOperation = new ExchangeOperation(user, currencyFrom, currencyTo, exchangeList.get(0));
        exchangeOperationRepository.save(exchangeOperation);

        return new ExchangeResponse(exchangeOperation.getId(), exchangeList.get(1).longValue());
    }

    private List<BigDecimal> exchangedAmount(BigDecimal courseAmountFrom, BigDecimal courseAmountTo, BigDecimal operationAmount) {
        List<BigDecimal> exchangeList = new ArrayList<>(2);
        exchangeList.add(operationAmount.multiply(courseAmountFrom));
        exchangeList.add(exchangeList.get(0).divide(courseAmountTo, RoundingMode.HALF_DOWN));

        return exchangeList;
    }
}

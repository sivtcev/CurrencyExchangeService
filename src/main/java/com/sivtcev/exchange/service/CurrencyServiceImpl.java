package com.sivtcev.exchange.service;

import com.sivtcev.exchange.entity.Currency;
import com.sivtcev.exchange.repository.CurrencyRepository;
import com.sivtcev.exchange.utility.restTemplate.CurrencyUpdateAnswer;
import com.sivtcev.exchange.utility.restTemplate.CurrencyUpdater;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final CurrencyUpdater currencyUpdater;

    @Override
    public void checkCurrencyUpdate(String from, String to) {
        Currency currencyFrom = currencyRepository.findByName(from);
        Currency currencyTo = currencyRepository.findByName(to);

        if (currencyFrom == null || currencyTo == null ||
                (currencyFrom.getUpdateTime().isBefore(LocalDateTime.now().minusDays(1L)) &&
                                currencyTo.getUpdateTime().isBefore(LocalDateTime.now().minusDays(1L)))) {
            CurrencyUpdateAnswer currencyUpdateAnswer = currencyUpdater.getUpdate();
            currencyRepository.deleteAll();
            currencyRepository.saveAll(currencyUpdateAnswer.getConversionRates());
        }
    }
}

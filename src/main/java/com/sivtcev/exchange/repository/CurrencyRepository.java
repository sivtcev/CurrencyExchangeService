package com.sivtcev.exchange.repository;

import com.sivtcev.exchange.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    Currency findByName(String name);
}

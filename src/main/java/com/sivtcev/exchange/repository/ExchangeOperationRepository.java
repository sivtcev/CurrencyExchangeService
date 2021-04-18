package com.sivtcev.exchange.repository;

import com.sivtcev.exchange.api.response.CurrencyResponse;
import com.sivtcev.exchange.entity.ExchangeOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeOperationRepository extends JpaRepository<ExchangeOperation, Long> {

    @Query(value = "SELECT currency_from, currency_to, amount_in_usd FROM operation GROUP BY currency_from, currency_to ORDER BY COUNT(amount_in_usd)", nativeQuery = true)
    List<CurrencyResponse> getRating();
}

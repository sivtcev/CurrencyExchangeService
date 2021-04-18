package com.sivtcev.exchange.repository;

import com.sivtcev.exchange.entity.ExchangeOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeOperationRepository extends JpaRepository<ExchangeOperation, Long> {
}

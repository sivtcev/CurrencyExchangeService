package com.sivtcev.exchange.service;

import com.sivtcev.exchange.api.response.CurrencyListResponse;
import com.sivtcev.exchange.api.response.UserListResponse;
import com.sivtcev.exchange.api.response.UserResponse;
import com.sivtcev.exchange.entity.ExchangeOperation;
import com.sivtcev.exchange.repository.ExchangeOperationRepository;
import com.sivtcev.exchange.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@AllArgsConstructor
public class StatisticServiceImpl implements StatisticService {
    private final long MIN_ONCE_BIG_OPERATION = 10_000L;
    private final long MIN_TOTAL_BIG_OPERATION = 100_000L;
    private final UserRepository userRepository;
    private final ExchangeOperationRepository operationRepository;

    @Override
    public UserListResponse getUsersWithOnceBigOperation() {
        log.debug("Start to get user list with once big operation");
        List<UserResponse> users = operationRepository.findAll()
                .stream()
                .filter(operation -> operation.getAmountInUSD().longValue() > MIN_ONCE_BIG_OPERATION)
                .sorted(Comparator.comparing(ExchangeOperation::getAmountInUSD))
                .map(UserResponse::new)
                .collect(Collectors.toList());
        return new UserListResponse(users);
    }

    @Override
    public UserListResponse getUsersWithTotalBigOperation() {
        log.debug("Start to get user list with total big operation");
        List<UserResponse> users = userRepository.findAll()
                .stream()
                .filter(user -> user.getOperations().stream()
                .mapToLong(ExchangeOperation::getAmountInUSDLong)
                .sum() > MIN_TOTAL_BIG_OPERATION)
                .map(UserResponse::new)
                .collect(Collectors.toList());
        return new UserListResponse(users);
    }

    @Override
    public CurrencyListResponse getCurrencyRating() {
        return new CurrencyListResponse(operationRepository.getRating());
    }
}

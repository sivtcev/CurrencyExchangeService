package com.sivtcev.exchange.api.response;

import com.sivtcev.exchange.entity.ExchangeOperation;
import com.sivtcev.exchange.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class UserResponse {

    private String name;
    private long amount;

    public UserResponse(ExchangeOperation exchangeOperation) {
        this.name = exchangeOperation.getUser().getName();
        this.amount = exchangeOperation.getAmountInUSD().longValue();
    }

    public UserResponse(User user) {
        this.name = user.getName();
        this.amount = user.getOperations().stream()
                .mapToLong(ExchangeOperation::getAmountInUSDLong)
                .sum();
    }
}

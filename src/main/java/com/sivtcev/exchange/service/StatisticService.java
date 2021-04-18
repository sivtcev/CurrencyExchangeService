package com.sivtcev.exchange.service;

import com.sivtcev.exchange.api.response.CurrencyListResponse;
import com.sivtcev.exchange.api.response.UserListResponse;

public interface StatisticService {

    UserListResponse getUsersWithOnceBigOperation();

    UserListResponse getUsersWithTotalBigOperation();

    CurrencyListResponse getCurrencyRating();

}

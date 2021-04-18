package com.sivtcev.exchange.controller;

import com.sivtcev.exchange.api.response.CurrencyListResponse;
import com.sivtcev.exchange.api.response.UserListResponse;
import com.sivtcev.exchange.service.StatisticService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
@AllArgsConstructor
public class StatisticController {

    private final StatisticService statisticService;

    @RequestMapping("/once")
    public ResponseEntity<UserListResponse> getUsersWithOnceBigOperation(){
        return ResponseEntity.ok(statisticService.getUsersWithOnceBigOperation());
    }

    @RequestMapping("/total")
    public ResponseEntity<UserListResponse> getUsersWithTotalBigOperation(){
        return ResponseEntity.ok(statisticService.getUsersWithTotalBigOperation());
    }

    @RequestMapping("/rating")
    public ResponseEntity<CurrencyListResponse> getCurrencyRating(){
        return ResponseEntity.ok(statisticService.getCurrencyRating());
    }
}

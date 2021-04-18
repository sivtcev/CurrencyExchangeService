package com.sivtcev.exchange.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ExchangeOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime operationTime;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Currency currencyFrom;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Currency currencyTo;

    private BigDecimal amountInUSD;

    public ExchangeOperation(User user, Currency from, Currency to, BigDecimal amountInUSD){
        this.operationTime = LocalDateTime.now();
        this.user = user;
        this.currencyFrom = from;
        this.currencyTo = to;
        this.amountInUSD = amountInUSD;
    }
}

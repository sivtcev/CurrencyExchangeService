package com.sivtcev.exchange.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "currencies")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private LocalDateTime updateTime;

    private BigDecimal amountInUSD;

    public Currency(String name, BigDecimal amountInUSD) {
        this.name = name;
        this.updateTime = LocalDateTime.now();
        this.amountInUSD = amountInUSD;
    }
}

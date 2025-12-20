package com.chaojun.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    private String orderId;
    private String userId;
    private BigDecimal amount;
}



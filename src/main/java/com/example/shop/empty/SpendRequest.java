package com.example.shop.empty;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SpendRequest {
    private int userId;
    private double amount;
}

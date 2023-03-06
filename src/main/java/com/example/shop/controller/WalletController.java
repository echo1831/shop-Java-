package com.example.shop.controller;

import com.example.shop.service.WalletService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WalletController {
    private final WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    // query balance of user by userid
    @RequestMapping("/balance/{userId}")
    public String getBalanceByUserId(@PathVariable int userId) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        double balance=walletService.getBalanceByUserId(userId);
        Map<String, Double> map= new HashMap<>();
        map.put("value",balance);
        return objectMapper.writeValueAsString(map);
    }


}

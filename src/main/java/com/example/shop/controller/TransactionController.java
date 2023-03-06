package com.example.shop.controller;

import com.example.shop.empty.SpendRequest;
import com.example.shop.empty.Transaction;
import com.example.shop.service.TransactionService;
import com.example.shop.service.WalletService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    private WalletService walletService;

    @Autowired
    private TransactionService transactionService;

    //to json
    ObjectMapper objectMapper = new ObjectMapper();

    //spend transaction
    //花费事务
    @PostMapping("/spend")
    public String spend(@RequestBody SpendRequest spendRequest){
        try {
            transactionService.spend(spendRequest.getUserId(),spendRequest.getAmount());
            return "ok";
        } catch (Exception e) {
            return "fail";
        }
    }

    //refund transaction
    //退款事务
    @PostMapping("/refund")
    public String refund(@RequestBody SpendRequest spendRequest){
        try {
            transactionService.refund(spendRequest.getUserId(),spendRequest.getAmount());
            return "ok";
        } catch (Exception e) {
            return "fail";
        }
    }

    //query all transactions...
    //查询全部事务
    @RequestMapping("/queryTransaction/{id}")
    public String queryTransaction(@PathVariable int id) throws JsonProcessingException {

        List<Transaction> transactions = transactionService.queryAllTransactions(id);
        return objectMapper.writeValueAsString(transactions);
    }
}

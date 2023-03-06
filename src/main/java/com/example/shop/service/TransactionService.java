package com.example.shop.service;

import com.example.shop.empty.Transaction;

import java.util.List;

public interface TransactionService {
    public int addTransaction(Transaction transaction);
    public void spend(int userId, double amount)throws Exception;
    public void refund(int userId,double amount)throws Exception;

    List<Transaction> queryAllTransactions(int userId);
}

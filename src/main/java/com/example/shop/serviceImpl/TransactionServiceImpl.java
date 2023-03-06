package com.example.shop.serviceImpl;

import com.example.shop.empty.Transaction;
import com.example.shop.empty.Wallet;
import com.example.shop.mapper.TransactionMapper;
import com.example.shop.mapper.WalletMapper;
import com.example.shop.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private WalletMapper walletMapper;
    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public int addTransaction(Transaction transaction) {
        return transactionMapper.addTransaction(transaction);
    }


    @Override
    @Transactional
    public void spend(int userId, double amount) throws Exception {
        Wallet wallet = walletMapper.getWalletByUserId(userId);
        if (wallet == null) {
            throw new Exception("User wallet not found");
        }
        if (wallet.getBalance()-amount<0) {
            throw new Exception("Insufficient balance");
        }
        /**
         * 2 steps are need
         * 1. add transaction
         * 2. update wallet
         */
        Transaction transaction = new Transaction();
        transaction.setWalletId(wallet.getId());
        transaction.setAmount(wallet.getBalance());
        transaction.setType(1);
        addTransaction(transaction);

        wallet.setBalance(wallet.getBalance()-amount);
        walletMapper.updateWallet(wallet);
    }

    @Override
    @Transactional
    public void refund(int userId, double amount) throws Exception {
        Wallet wallet = walletMapper.getWalletByUserId(userId);
        if (wallet == null) {
            throw new Exception("User wallet not found");
        }
        if (amount<0) {
            throw new Exception("refund can not be negative number");
        }
        /**
         * As written above, 2 steps are need
         * 1. add transaction
         * 2. update wallet
         */
        Transaction transaction = new Transaction();
        transaction.setWalletId(wallet.getId());
        transaction.setAmount(wallet.getBalance());
        transaction.setType(0);
        addTransaction(transaction);

        wallet.setBalance(wallet.getBalance()+amount);
        walletMapper.updateWallet(wallet);
    }

    @Override
    public List<Transaction> queryAllTransactions(int userId) {
        return transactionMapper.queryAllTransactions(userId);
    }
}

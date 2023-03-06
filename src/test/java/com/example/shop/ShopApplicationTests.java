package com.example.shop;

import com.example.shop.empty.Transaction;
import com.example.shop.empty.Wallet;
import com.example.shop.service.TransactionService;
import com.example.shop.service.WalletService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShopApplicationTests {

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private WalletService walletService;
    @Test
    void contextLoads() {
    }

    @Test
    void transactonTest(){
        Transaction transaction = new Transaction();
        transaction.setWalletId(1);
        transaction.setType(1);
        transaction.setAmount(10);
        transactionService.addTransaction(transaction);
    }
    @Test
    void updateWallet(){
        Wallet wallet=new Wallet();
        wallet.setBalance(1211);
        wallet.setUserId(11);

        walletService.updateWallet(wallet);
    }
    @Test
    void getWalletByUserIdTest(){
        Wallet wallet = walletService.getWalletByUserId(11);
        System.out.println(wallet);
    }

    @Test
    void trTest() throws Exception {
        transactionService.spend(11,6);
    }
    @Test
    void refundTest() throws Exception {
        transactionService.refund(11,7);
    }

}

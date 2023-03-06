package com.example.shop.serviceImpl;

import com.example.shop.empty.Wallet;
import com.example.shop.mapper.WalletMapper;
import com.example.shop.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletMapper walletMapper;


    @Override
    public double getBalanceByUserId(int userId) {
        return walletMapper.getBalanceByUserId(userId);
    }

    @Override
    public Wallet getWalletByUserId(int userId) {
        return walletMapper.getWalletByUserId(userId);
    }

    @Override
    public int updateWallet(Wallet wallet) {
        return walletMapper.updateWallet(wallet);
    }
}

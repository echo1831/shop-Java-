package com.example.shop.service;

import com.example.shop.empty.Wallet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface WalletService {
    double getBalanceByUserId(int userId);

    Wallet getWalletByUserId(int userId);


    int updateWallet(Wallet wallet);
}

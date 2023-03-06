package com.example.shop.mapper;

import com.example.shop.empty.Wallet;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;

@Mapper
public interface WalletMapper {
    @Select("select balance from wallets where user_id=#{id}")
    double getBalanceByUserId(@Param("id") int userId);

    @Results(id = "userResultMap", value = {
            @Result(column = "user_id", property = "userId")
    })
    @Select("select id,user_id,balance from wallets where user_id=#{userId}")
    Wallet getWalletByUserId(@Param(("userId")) int userId);

    @Update("update wallets set balance=#{balance}")
    int updateWallet(Wallet wallet);
}

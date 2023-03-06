package com.example.shop.mapper;

import com.example.shop.empty.Transaction;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TransactionMapper {
    @Options(useGeneratedKeys=true, keyProperty="id")
    @Insert("insert into transactions" +
            " (wallet_id, transaction_type,amount,transaction_time) " +
            "values(#{walletId},#{type},#{amount},now())")
    int addTransaction(Transaction transaction);


    @Results(id = "transactionsResultMap", value = {
            @Result(column = "transaction_time", property = "date")
    })
    @Select("select * from transactions " +
            "where wallet_id in " +
                "(select id from wallets " +
                "where user_id = #{userId})"
    )
    List<Transaction> queryAllTransactions(int UserId);
}

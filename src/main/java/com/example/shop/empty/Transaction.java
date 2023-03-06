package com.example.shop.empty;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Transaction {

    private int id;
    private int walletId;
    private int type;
    private double amount;
    private Date date;


}

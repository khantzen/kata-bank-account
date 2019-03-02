package com.khantzen.kata.bankaccount.operation;

import com.khantzen.kata.bankaccount.util.DateConverter;

import java.util.Date;

class Transaction {
    private final float amount;
    private final Date date;
    private final float balance;

    Transaction(float amount, String date, float balance) {
        this.amount = amount;
        this.date = DateConverter.convertStringUsingFormat(date, "yyyy/MM/dd");;
        this.balance = balance;
    }

    public float getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public float getBalance() {
        return balance;
    }
}

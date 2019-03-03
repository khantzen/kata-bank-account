package com.khantzen.kata.bankaccount.operation;

import com.khantzen.kata.bankaccount.util.DateConverter;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

class Transaction {
    private final float amount;
    private final Date date;
    private final float balance;

    Transaction(float amount, String date, float balance) {
        this.amount = amount;
        this.date = getTransactionDate(date);
        this.balance = balance;
    }

    private Date getTransactionDate(String date) {
        Optional<Date> transactionDate = DateConverter.convertStringUsingFormat(date, "yyyy/MM/dd");
        Date currentDate = Calendar.getInstance().getTime();
        return transactionDate.orElse(currentDate);
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

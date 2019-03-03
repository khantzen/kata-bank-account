package com.khantzen.kata.bankaccount.operation;

import com.khantzen.kata.bankaccount.util.DateConverter;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class Transaction {
    public static final String TRANSACTION_DATE_FORMAT = "yyyy/MM/dd";

    private final float amount;
    private final Date date;
    private final float balance;

    public Transaction(float amount, String date, float balance) {
        this.amount = amount;
        this.date = getTransactionDate(date);
        this.balance = balance;
    }

    private Date getTransactionDate(String date) {
        Optional<Date> transactionDate = DateConverter.convertStringUsingFormat(date, TRANSACTION_DATE_FORMAT);
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

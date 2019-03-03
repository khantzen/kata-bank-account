package com.khantzen.kata.bankaccount.operation;

import com.khantzen.kata.bankaccount.util.DateConverter;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class Transaction {
    static final String TRANSACTION_DATE_FORMAT = "yyyy/MM/dd";

    private final Amount amount;
    private final Date date;
    private final Amount balance;

    public Transaction(Amount amount, String date, Amount balance) {
        this.amount = amount;
        this.date = getTransactionDate(date);
        this.balance = balance;
    }

    private Date getTransactionDate(String date) {
        Optional<Date> transactionDate = DateConverter.convertStringUsingFormat(date, TRANSACTION_DATE_FORMAT);
        Date currentDate = Calendar.getInstance().getTime();
        return transactionDate.orElse(currentDate);
    }

    public Amount getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public Amount getBalance() {
        return balance;
    }
}

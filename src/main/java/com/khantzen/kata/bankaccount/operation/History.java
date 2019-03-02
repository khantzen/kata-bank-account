package com.khantzen.kata.bankaccount.operation;

import java.util.Comparator;
import java.util.TreeSet;

public class History {
    private TreeSet<Transaction> transactionList;

    public History() {
        this.transactionList = new TreeSet<>(Comparator.comparing(Transaction::getDate).reversed());
    }

    public void appendTransaction(Transaction transaction) {
        this.transactionList.add(transaction);
    }
}

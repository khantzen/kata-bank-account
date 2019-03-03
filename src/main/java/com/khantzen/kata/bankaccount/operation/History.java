package com.khantzen.kata.bankaccount.operation;

import com.khantzen.kata.bankaccount.util.SimpleTransactionFormat;

import java.util.*;
import java.util.function.Function;

public class History {
    private static int DEFAULT_SECTION_LENGTH = 10;

    private List<Transaction> transactionList;

    public History() {
        this.transactionList = new ArrayList<>();
    }

    public void appendTransaction(Transaction transaction) {
        this.transactionList.add(transaction);
    }

    public void print() {
        int amountSectionLength = this.getAmountSectionLength();
        int balanceSectionLength = this.getBalanceSectionLength();

        SimpleTransactionFormat transactionFormat =
                new SimpleTransactionFormat(
                        Transaction.TRANSACTION_DATE_FORMAT,
                        amountSectionLength,
                        balanceSectionLength
                );

        String historyHeader = transactionFormat.buildHeader();
        System.out.println(historyHeader);
        this.printHistoryBody(transactionFormat);
    }


    private void printHistoryBody(SimpleTransactionFormat transactionFormat) {
        this.transactionList.stream()
                .sorted(Comparator.comparing(Transaction::getDate).reversed())
                .map(transactionFormat::format)
                .forEach(System.out::println);
    }

    int getAmountSectionLength() {
        return this.getTransactionSectionLengthFor(Transaction::getAmount);
    }

    int getBalanceSectionLength() {
        return this.getTransactionSectionLengthFor(Transaction::getBalance);
    }

    private int getTransactionSectionLengthFor(Function<Transaction, Amount> getValue) {
        Optional<Amount> longestAmount = transactionList.stream()
                .map(getValue)
                .max(Amount::compareLength);

        Amount a = longestAmount.get();

        return longestAmount.map(s -> s.length() + 3).orElse(DEFAULT_SECTION_LENGTH);
    }
}

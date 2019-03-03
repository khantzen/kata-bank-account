package com.khantzen.kata.bankaccount.operation;

import com.khantzen.kata.bankaccount.util.TransactionFormat;

import java.util.*;
import java.util.function.Function;

/**
 * History class contains all the transaction that have been made to our bank account
 */
class History {
    private List<Transaction> transactionList;

    History() {
        this.transactionList = new ArrayList<>();
    }

    void appendTransaction(Transaction transaction) {
        this.transactionList.add(transaction);
    }

    /**
     * print method will use TransactionFormat util class to print a well formatted transaction history
     */
    void print() {
        int amountSectionLength = this.getAmountCaseLength();
        int balanceSectionLength = this.getBalanceSectionLength();

        TransactionFormat transactionFormat =
                new TransactionFormat(
                        Transaction.TRANSACTION_DATE_FORMAT,
                        amountSectionLength,
                        balanceSectionLength
                );

        String historyHeader = transactionFormat.buildHeader();

        System.out.println(historyHeader);
        this.printHistoryBody(transactionFormat);
    }


    private void printHistoryBody(TransactionFormat transactionFormat) {
        this.transactionList.stream()
                .sorted(Comparator.comparing(Transaction::getDate).reversed())
                .map(transactionFormat::format)
                .forEach(System.out::println);
    }

    /**
     *
     * @return the length for the Amount case when printing history
     */
    int getAmountCaseLength() {
        return this.getTransactionSectionLengthFor(Transaction::getAmount);
    }

    /**
     *
     * @return the length for the Balance case when printing history
     */
    int getBalanceSectionLength() {
        return this.getTransactionSectionLengthFor(Transaction::getBalance);
    }

    private int getTransactionSectionLengthFor(Function<Transaction, Amount> getValue) {
        Optional<Amount> longestAmount = transactionList.stream()
                .map(getValue)
                .max(Amount::compareLength);

        return longestAmount.map(s -> s.length() + 3).orElse(10);
    }
}

package com.khantzen.kata.bankaccount.util;

import com.khantzen.kata.bankaccount.operation.Amount;
import com.khantzen.kata.bankaccount.operation.Transaction;

import java.util.Date;

/**
 * TransactionFormat is a class for formatting Transaction in a human readable string
 */
public class TransactionFormat {
    private final String datePattern;
    private final int amountCaseLength;
    private final int balanceCaseLength;

    public TransactionFormat(String datePattern, int amountCaseLength, int balanceCaseLength) {
        this.datePattern = datePattern;
        this.amountCaseLength = amountCaseLength;
        this.balanceCaseLength = balanceCaseLength;
    }

    /**
     *
     * @return The transaction header for the current instance
     */
    public String buildHeader() {
        String headerDate = "|" + this.getHeaderSectionFor("Date", 12);
        String headerAmount = this.getHeaderSectionFor("Amount", this.amountCaseLength);
        String headerBalance = this.getHeaderSectionFor("Balance", this.balanceCaseLength);
        return headerDate + headerAmount + headerBalance;
    }

    private String getHeaderSectionFor(String name, int length) {
        StringBuilder headerSection = new StringBuilder(" " + name);
        while (headerSection.length() < length) {
            headerSection.append(" ");
        }
        headerSection.append("|");
        return headerSection.toString();
    }

    /**
     *
     * @param transaction
     * @return format the given transaction in a human readable string
     */
    public String format(Transaction transaction) {
        String formattedTransactionDate = getTransactionDateAsString(transaction.getDate());
        String formattedTransactionAmount = formatValueToString(transaction.getAmount(), this.amountCaseLength);
        String formattedTransactionBalance = formatValueToString(transaction.getBalance(), this.balanceCaseLength);

        return buildTransactionString(formattedTransactionDate, formattedTransactionAmount, formattedTransactionBalance);
    }

    private String getTransactionDateAsString(Date transactionDate) {
        return " " + DateConverter.convertDateToString(transactionDate, this.datePattern) + " ";
    }

    private String formatValueToString(Amount amount, int sectionLength) {
        StringBuilder stringBuilder = new StringBuilder(" " + amount);

        while (stringBuilder.length() < sectionLength) {
            stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }

    private String buildTransactionString(String date, String amount, String balance) {
        return "|" + date +
                "|" + amount +
                "|" + balance +
                "|";
    }
}

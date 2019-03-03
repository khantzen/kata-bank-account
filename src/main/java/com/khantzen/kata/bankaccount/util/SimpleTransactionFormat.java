package com.khantzen.kata.bankaccount.util;

import com.khantzen.kata.bankaccount.operation.Transaction;

import java.util.Date;

public class SimpleTransactionFormat {
    private final String datePattern;
    private final int amountSectionLength;
    private final int balanceSectionLength;

    public SimpleTransactionFormat(String datePattern, int amountSectionLength, int balanceSectionLength) {
        this.datePattern = datePattern;
        this.amountSectionLength = amountSectionLength;
        this.balanceSectionLength = balanceSectionLength;
    }

    public String buildHeader() {
        String headerDate = "|" + this.getHeaderSectionFor("Date", 12);
        String headerAmount = this.getHeaderSectionFor("Amount", this.amountSectionLength);
        String headerBalance = this.getHeaderSectionFor("Balance", this.balanceSectionLength);
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

    public String format(Transaction transaction) {
        String formattedTransactionDate = getTransactionDateAsString(transaction);
        String formattedTransactionAmount = getTransactionAmountAsString(transaction);
        String formattedTransactionBalance = getTransactionBalanceAsString(transaction);

        return buildTransactionString(formattedTransactionDate, formattedTransactionAmount, formattedTransactionBalance);
    }

    private String getTransactionDateAsString(Transaction transaction) {
        Date transactionDate = transaction.getDate();
        return " " + DateConverter.convertDateToString(transactionDate, this.datePattern) + " ";
    }

    private String getTransactionAmountAsString(Transaction transaction) {
        float amount = transaction.getAmount();
        return formatValueToString(amount, this.amountSectionLength);
    }

    private String getTransactionBalanceAsString(Transaction transaction) {
        float balance = transaction.getBalance();
        return formatValueToString(balance, this.balanceSectionLength);
    }

    private String formatValueToString(float amount, int sectionLength) {
        String sign = amount > 0 ? "+" : "";

        String truncatedAmount = String.format("%.2f", amount);
        StringBuilder amountAsString = new StringBuilder(" " + sign + truncatedAmount);

        while (amountAsString.length() < sectionLength) {
            amountAsString.append(" ");
        }

        return amountAsString.toString();
    }

    private String buildTransactionString(String date, String amount, String balance) {
        return "|" + date +
                "|" + amount +
                "|" + balance +
                "|";
    }
}

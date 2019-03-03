package com.khantzen.kata.bankaccount.util;

import com.khantzen.kata.bankaccount.operation.Transaction;

import java.util.Date;

public class SimpleTransactionFormat {
    private final String datePattern;
    private final int amountLengthSection;
    private final int balanceLengthSection;

    public SimpleTransactionFormat(String datePattern, int amountLengthSection, int balanceLengthSection) {
        this.datePattern = datePattern;
        this.amountLengthSection = amountLengthSection;
        this.balanceLengthSection = balanceLengthSection;
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
        return formatValueToString(amount, this.amountLengthSection);
    }

    private String getTransactionBalanceAsString(Transaction transaction) {
        float balance = transaction.getBalance();
        return formatValueToString(balance, this.balanceLengthSection);
    }

    private String formatValueToString(float amount, int sectionLength) {
        String sign = amount > 0 ? "+" : "";

        StringBuilder amountAsString = new StringBuilder(" " + sign + amount);

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

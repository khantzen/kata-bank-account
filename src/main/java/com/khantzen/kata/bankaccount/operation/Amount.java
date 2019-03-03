package com.khantzen.kata.bankaccount.operation;

public class Amount {

    private float value;

    public Amount(float initialAmount) {
        this.value = initialAmount;
    }

    float getValue() {
        return value;
    }

    Amount add(Amount amount) {
        return new Amount(value + amount.value);
    }


    @Override
    public String toString() {
        String sign = this.value > 0 ? "+":"";
        String truncatedAmount = amountValueToString();
        return sign + truncatedAmount;
    }

    private String amountValueToString() {
        return String.format("%.2f", value);
    }

    static int compareLength(Amount am1, Amount am2) {
        Integer am1Length = am1.length();
        Integer am2Length = am2.length();
        return am1Length - am2Length;
    }

    Integer length() {
        Amount absoluteAmount = this.abs();
        String truncatedAmount = absoluteAmount.amountValueToString();
        return truncatedAmount.length();
    }

    private Amount abs() {
        return new Amount(Math.abs(value));
    }
}

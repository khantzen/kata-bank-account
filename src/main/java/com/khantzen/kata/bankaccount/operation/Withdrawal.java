package com.khantzen.kata.bankaccount.operation;

public class Withdrawal {
    private float amount;

    public Withdrawal(float amount, String date) {
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }
}

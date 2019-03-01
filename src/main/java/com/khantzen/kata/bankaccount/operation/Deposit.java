package com.khantzen.kata.bankaccount.operation;

public class Deposit {
    private float amount;

    public Deposit(float amount, String depositDate) {
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }
}

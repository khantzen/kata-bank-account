package com.khantzen.kata.bankaccount.operation;

public class DepositOperation {
    private float amount;

    public DepositOperation(float amount, String depositDate) {
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }
}

package com.khantzen.kata.bankaccount.model;

import com.khantzen.kata.bankaccount.operation.DepositOperation;

public class BankAccount {
    private float balance;

    public BankAccount() {
        this.balance = 0;
    }

    public void applyDeposit(DepositOperation depositOperation) {
        this.balance += depositOperation.getAmount();
    }

    public float getBalance() {
        return balance;
    }
}

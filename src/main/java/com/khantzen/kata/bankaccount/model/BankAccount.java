package com.khantzen.kata.bankaccount.model;

import com.khantzen.kata.bankaccount.operation.Deposit;
import com.khantzen.kata.bankaccount.operation.Withdrawal;

public class BankAccount {
    private float balance;

    public BankAccount() {
        this.balance = 0;
    }

    public void applyDeposit(Deposit deposit) {
        this.balance += deposit.getAmount();
    }

    public void applyWithdrawal(Withdrawal withdrawal) {
        this.balance -= withdrawal.getAmount();
    }

    public float getBalance() {
        return balance;
    }
}

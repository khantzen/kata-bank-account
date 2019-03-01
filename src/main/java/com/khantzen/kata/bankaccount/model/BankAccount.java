package com.khantzen.kata.bankaccount.model;

public class BankAccount {
    private float balance;

    public BankAccount() {
        this.balance = 0;
    }

    public void deposit(float amount, String date) {
        this.balance += amount;
    }

    public void withdrawal(float amount, String date) {
        this.balance -= amount;
    }

    public float getBalance() {
        return balance;
    }
}

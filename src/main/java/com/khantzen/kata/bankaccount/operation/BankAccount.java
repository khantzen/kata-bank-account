package com.khantzen.kata.bankaccount.operation;

public class BankAccount {
    private float balance;
    private History history;

    public BankAccount(float initialAmount) {
        this.balance = initialAmount;
        this.history = new History();
    }

    public void deposit(float amount, String date) {
        this.applyTransaction(amount);
        this.registerTransactionInHistory(amount, date);
    }

    public void withdrawal(float amount, String date) {
        float amountToRemove = -amount;
        this.applyTransaction(amountToRemove);
        this.registerTransactionInHistory(amountToRemove, date);
    }

    private void applyTransaction(float amount) {
        this.balance += amount;
    }

    private void registerTransactionInHistory(float amount, String date) {
        Transaction transaction = new Transaction(amount, date, this.balance);
        this.history.appendTransaction(transaction);
    }

    public void printHistory() {
        this.history.print();
    }

    public float getBalance() {
        return balance;
    }
}

package com.khantzen.kata.bankaccount.operation;

public class BankAccount {
    private Amount balance;
    private History history;

    public BankAccount(float initialAmount) {
        this.balance = new Amount(initialAmount);
        this.history = new History();
    }

    public void deposit(float amount, String date) {
        Amount depositAmount = new Amount(amount);
        this.applyTransaction(depositAmount);
        this.registerTransactionInHistory(depositAmount, date);
    }

    public void withdrawal(float amount, String date) {
        Amount withdrawalAmount = new Amount(-amount);
        this.applyTransaction(withdrawalAmount);
        this.registerTransactionInHistory(withdrawalAmount, date);
    }

    private void applyTransaction(Amount amount) {
        this.balance = this.balance.add(amount);
    }

    private void registerTransactionInHistory(Amount amount, String date) {
        Transaction transaction = new Transaction(amount, date, this.balance);
        this.history.appendTransaction(transaction);
    }

    public void printHistory() {
        this.history.print();
    }

    public Amount getBalance() {
        return balance;
    }

    public float getBalanceValue() {
        return balance.getValue();
    }
}

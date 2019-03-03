package com.khantzen.kata.bankaccount;

import com.khantzen.kata.bankaccount.operation.BankAccount;

public class BankAccountMain {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(500.00f);

        bankAccount.deposit(1500.12f, "2015/03/25");
        bankAccount.deposit(2300.14f, "2016/03/25");
        bankAccount.withdrawal(2350.14f, "2018/03/25");
        bankAccount.deposit(7850.14f, "2019/03/25");

        bankAccount.printHistory();
    }
}

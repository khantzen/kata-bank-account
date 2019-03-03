package com.khantzen.kata.bankaccount.operation;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BankAccountStep {
    private BankAccount bankAccount;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp()  {
        System.setOut(new PrintStream(outContent));
    }

    @Given("^a bank account with (\\d+\\.\\d+)$")
    public void a_bank_account_with(float amount) throws Throwable {
        this.bankAccount = new BankAccount(amount);
    }

    @When("^I deposit (\\d+\\.\\d+) on (\\d+/\\d+/\\d+)$")
    public void makingADeposit(float amount, String date) {
        this.bankAccount.deposit(amount, date);
    }

    @When("^I withdrawal (\\d+\\.\\d+) on (\\d+/\\d+/\\d+)$")
    public void makingAWithdrawal(float amount, String date) {
        this.bankAccount.withdrawal(amount, date);
    }

    @Then("^bank account balance should be (-*\\d+\\.\\d+)$")
    public void checkAccountBalanceIs(float expectedBankAccountBalance) throws Throwable {
        float bankAccountBalance = this.bankAccount.getBalanceValue();
        Assertions.assertThat(bankAccountBalance).isEqualTo(expectedBankAccountBalance);
    }

    @When("^I ask for my bank account operation history$")
    public void getOperationHistory() {
        this.bankAccount.printHistory();
    }

    @Then("^I should have$")
    public void checkOperationHistoryIs(String expectedHistory) throws Throwable {
        Assertions.assertThat(this.outContent.toString()).isEqualTo(expectedHistory);
    }
}

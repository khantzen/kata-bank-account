package com.khantzen.kata.bankaccount.operation;

import com.khantzen.kata.bankaccount.model.BankAccount;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

public class DepositOperationStep {
    private BankAccount bankAccount;

    @Given("^a bank account$")
    public void implementDefaultBankAccount() throws Throwable {
      this.bankAccount = new BankAccount();
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
    public void i_should_have_balance_on_my_account(float expectedBankAccountBalance) throws Throwable {
        float bankAccountBalance = this.bankAccount.getBalance();
        Assertions.assertThat(bankAccountBalance).isEqualTo(expectedBankAccountBalance);
    }
}

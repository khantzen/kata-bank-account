package com.khantzen.kata.bankaccount.operation;

import com.khantzen.kata.bankaccount.model.BankAccount;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

public class DepositOperationStep {
    private BankAccount bankAccount;

    @Given("^a bank account$")
    public void a_bank_account() throws Throwable {
      this.bankAccount = new BankAccount();
    }

    @When("^I deposit (\\d+\\.\\d+) on (\\d+/\\d+/\\d+)$")
    public void i_deposit_on(float depositAmount, String date) {
        DepositOperation depositOperation = new DepositOperation(depositAmount, date);
        this.bankAccount.applyDeposit(depositOperation);
    }

    @Then("^bank account balance should be (\\d+\\.\\d+)$")
    public void i_should_have_balance_on_my_account(float expectedBankAccountBalance) throws Throwable {
        float bankAccountBalance = this.bankAccount.getBalance();
        Assertions.assertThat(bankAccountBalance).isEqualTo(expectedBankAccountBalance);
    }
}

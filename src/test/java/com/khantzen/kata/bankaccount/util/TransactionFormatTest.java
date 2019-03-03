package com.khantzen.kata.bankaccount.util;

import com.khantzen.kata.bankaccount.operation.Amount;
import com.khantzen.kata.bankaccount.operation.Transaction;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TransactionFormatTest {

    @Test
    public void buildTransactionHeader_test() {
        TransactionFormat transactionFormat =
                new TransactionFormat("yyyy/MM/dd", 10, 10);

        String header = transactionFormat.buildHeader();

        Assertions.assertThat(header).isEqualTo("| Date       | Amount   | Balance  |");
    }

    @Test
    public void formatDepositTransaction_test() {
        TransactionFormat transactionFormat =
                new TransactionFormat("yyyy/MM/dd", 10, 15);

        Amount amount = new Amount(125.25f);
        Amount balance = new Amount(987.26f);
        Transaction transaction = new Transaction(amount, "2019/07/10", balance);

        String formattedTransaction = transactionFormat.format(transaction);
        Assertions.assertThat(formattedTransaction).isEqualTo("| 2019/07/10 | +125.25  | +987.26       |");
    }

    @Test
    public void formatWithdrawalTransaction_test() {
        TransactionFormat transactionFormat =
                new TransactionFormat("yyyy/MM/dd", 9, 12);

        Amount amount = new Amount(-125.25f);
        Amount balance = new Amount(987.26f);
        Transaction transaction = new Transaction(amount, "2019/07/10", balance);

        String formattedTransaction = transactionFormat.format(transaction);
        Assertions.assertThat(formattedTransaction).isEqualTo("| 2019/07/10 | -125.25 | +987.26    |");
    }

}

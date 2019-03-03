package com.khantzen.kata.bankaccount.util;

import com.khantzen.kata.bankaccount.operation.Transaction;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TransactionFormatTest {

    @Test
    public void formatDepositTransaction_test() {
        SimpleTransactionFormat transactionFormat =
                new SimpleTransactionFormat("yyyy/MM/dd", 10, 15);

        Transaction transaction = new Transaction(125.25f, "2019/07/10", 987.26f);

        String formattedTransaction = transactionFormat.format(transaction);
        Assertions.assertThat(formattedTransaction).isEqualTo("| 2019/07/10 | +125.25  | +987.26       |");
    }

    @Test
    public void formatWithdrawalTransaction_test() {
        SimpleTransactionFormat transactionFormat =
                new SimpleTransactionFormat("yyyy/MM/dd", 9, 12);

        Transaction transaction = new Transaction(-125.25f, "2019/07/10", 987.26f);

        String formattedTransaction = transactionFormat.format(transaction);
        Assertions.assertThat(formattedTransaction).isEqualTo("| 2019/07/10 | -125.25 | +987.26    |");
    }

}

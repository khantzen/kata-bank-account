package com.khantzen.kata.bankaccount.operation;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class HistoryPrintingTest {

    @Test
    public void getTransactionAmountSectionLengthFromHistory_Test() {
        History history = new History();
        history.appendTransaction(new Transaction(1258.25f, "2019/02/02", 1.00f));
        history.appendTransaction(new Transaction(-1255.73f, "2017/02/02", 1.00f));
        history.appendTransaction(new Transaction(125.25f, "2018/02/02", 1.00f));

        int amountSectionLength = history.getAmountSectionLength();

        Assertions.assertThat(amountSectionLength).isEqualTo(10);
    }

    @Test
    public void getTransactionBalanceSectionLengthFromHistory_Test() {
        History history = new History();
        history.appendTransaction(new Transaction(1.00f, "2019/02/02", 250.42f));
        history.appendTransaction(new Transaction(1.00f, "2019/02/02", 4788.35f));
        history.appendTransaction(new Transaction(1.00f, "2019/02/02", -350.41f));

        int amountSectionLength = history.getBalanceSectionLength();

        Assertions.assertThat(amountSectionLength).isEqualTo(10);
    }

}

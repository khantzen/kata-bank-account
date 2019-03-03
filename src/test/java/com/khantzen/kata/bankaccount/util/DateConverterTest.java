package com.khantzen.kata.bankaccount.util;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.fail;

public class DateConverterTest {

    @Test
    public void validDateConversion_test() {
        String dateToConvert = "2019/03/03";
        Optional<Date> optionalDate = DateConverter.convertStringUsingFormat(dateToConvert, "yyyy/MM/dd");

        if (!optionalDate.isPresent()) {
            fail("Date converter should have return a valid date");
        }

        Date convertedDate = optionalDate.get();
        Assertions.assertThat(convertedDate).isEqualTo("2019-03-03");
    }

    @Test
    public void invalidDateConversion_test() {
        String dateToConvert = "2019/14/36";
        Optional<Date> optionalDate = DateConverter.convertStringUsingFormat(dateToConvert, "yyyy/MM/dd");
        Assertions.assertThat(optionalDate.isPresent()).isFalse();
    }
}

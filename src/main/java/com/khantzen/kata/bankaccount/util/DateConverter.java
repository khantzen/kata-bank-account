package com.khantzen.kata.bankaccount.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class DateConverter {
    public static Optional<Date> convertStringUsingFormat(String date, String pattern) {
        SimpleDateFormat dateFormat = buildStrictDateFormatterFrom(pattern);

        try {
            Date parsedDate = dateFormat.parse(date);
            return Optional.of(parsedDate);
        } catch (ParseException e) {
            return Optional.empty();
        }
    }

    private static SimpleDateFormat buildStrictDateFormatterFrom(String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        dateFormat.setLenient(false);
        return dateFormat;
    }
}

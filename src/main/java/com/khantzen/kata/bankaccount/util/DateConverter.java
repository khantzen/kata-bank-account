package com.khantzen.kata.bankaccount.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * DateConverter is a class allowing to parse and format strict date following a given pattern
 */
public class DateConverter {
    /**
     *
     * @param date string containing date to parse
     * @param pattern pattern to parse the date
     * @return convert the given string into an Optional Date
     */
    public static Optional<Date> convertStringUsingFormat(String date, String pattern) {
        SimpleDateFormat dateFormatter = buildStrictDateFormatterFrom(pattern);

        try {
            Date parsedDate = dateFormatter.parse(date);
            return Optional.of(parsedDate);
        } catch (ParseException e) {
            return Optional.empty();
        }
    }

    /**
     *
     * @param date the Date that with want to format into a string
     * @param pattern The string pattern that we want for our date
     * @return A string containing the formatted Date
     */
    static String convertDateToString(Date date, String pattern) {
        SimpleDateFormat dateFormatter = buildStrictDateFormatterFrom(pattern);
        return dateFormatter.format(date);
    }

    private static SimpleDateFormat buildStrictDateFormatterFrom(String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        dateFormat.setLenient(false);
        return dateFormat;
    }
}

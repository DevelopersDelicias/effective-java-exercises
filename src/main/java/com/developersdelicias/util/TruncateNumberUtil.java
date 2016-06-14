package com.developersdelicias.util;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class TruncateNumberUtil {

    public static double truncate(double numberToTruncate, int numberOfDecimals) {
        validate(numberOfDecimals);
        return truncateNumber(numberToTruncate, numberOfDecimals);
    }

    private static double truncateNumber(double numberToTruncate, int numberOfDecimals) {
        BigDecimal bigDecimal = new BigDecimal(numberToTruncate).setScale(numberOfDecimals, RoundingMode.DOWN);
        return bigDecimal.doubleValue();
    }

    private static void validate(int numberOfDecimals) {
        if (numberOfDecimals < 0) {
            throw new IllegalArgumentException("Number of decimals must be greater or equal to zero.");
        }
    }
}

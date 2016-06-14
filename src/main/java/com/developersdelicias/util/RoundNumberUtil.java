package com.developersdelicias.util;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundNumberUtil {

    public static double round(double numberToRound, int numberOfDecimals) {
        BigDecimal bd = new BigDecimal(numberToRound).setScale(numberOfDecimals, RoundingMode.HALF_EVEN);
        return bd.doubleValue();
    }

    public static double roundToFourDecimals(double numberToRound) {
        return round(numberToRound, 4);
    }
}

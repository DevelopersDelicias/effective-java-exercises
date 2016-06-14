package com.developersdelicias.util;


public class RoundNumberUtil {

    public static double round(double numberToRound, int numberOfDecimals) {
        double multiplier = Math.pow(10, numberOfDecimals);
        return (double)Math.round(numberToRound * multiplier) / multiplier;
    }

    public static double roundToFourDecimals(double numberToRound) {
        return round(numberToRound, 4);
    }

}

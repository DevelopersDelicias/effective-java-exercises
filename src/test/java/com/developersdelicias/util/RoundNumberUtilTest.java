package com.developersdelicias.util;

import org.junit.Test;

import static com.developersdelicias.util.RoundNumberUtil.round;
import static com.developersdelicias.util.RoundNumberUtil.roundToFourDecimals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RoundNumberUtilTest {

    @Test
    public void should_round_number_to_four_digits() throws Exception {
        double numberToRound = 5.78968d;
        double expectedNumber = 5.7897d;
        assertThat(round(numberToRound, 4), is(expectedNumber));
    }

    @Test
    public void should_round_number_to_four_digits2() throws Exception {
        double numberToRound = 5.78961d;
        double expectedNumber = 5.7896d;
        assertThat(round(numberToRound, 4), is(expectedNumber));
    }

    @Test
    public void should_round_number_to_four_digits3() throws Exception {
        double numberToRound = 5.78962d;
        double expectedNumber = 5.7896d;
        assertThat(round(numberToRound, 4), is(expectedNumber));
    }

    @Test
    public void should_round_number_to_four_digits4() throws Exception {
        double numberToRound = 5.78962d;
        double expectedNumber = 5.7896d;
        assertThat(roundToFourDecimals(numberToRound), is(expectedNumber));
    }
}

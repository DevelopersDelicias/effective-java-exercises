package com.developersdelicias.util;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.developersdelicias.util.RoundNumberUtil.round;
import static com.developersdelicias.util.RoundNumberUtil.roundToFourDecimals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RoundNumberUtilTest {

    @Test
    @Parameters({"5.78965d", "5.78966d", "5.78967d", "5.78968d", "5.78969d"})
    public void should_round_number_to_four_digits_up(double numberToRound) throws Exception {
        double expectedNumber = 5.7897d;
        assertThat(roundToFourDecimals(numberToRound), is(expectedNumber));
    }

    @Test
    @Parameters({"5.78960d", "5.78961d", "5.78962d", "5.78963d", "5.78964d"})
    public void should_round_number_to_four_digits_down(double numberToRound) throws Exception {
        double expectedNumber = 5.7896d;
        assertThat(roundToFourDecimals(numberToRound), is(expectedNumber));
    }

    @Test
    public void should_round_numbers_with_different_number_of_decimals() throws Exception {
        assertThat(round(10.2365869, 2), is(10.24));
        assertThat(round(10.2365869, 7), is(10.2365869));
        assertThat(round(10.2365869, 0), is(10.0));
        assertThat(round(10.2365869, 8), is(10.2365869));
    }
}

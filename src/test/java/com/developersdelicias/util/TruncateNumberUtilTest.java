package com.developersdelicias.util;


import java.lang.IllegalArgumentException;
import org.junit.Test;

import static com.developersdelicias.util.TruncateNumberUtil.truncate;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TruncateNumberUtilTest {

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_an_invalid_argument_exception_with_negative_number() throws Exception {
        truncate(1.3145464648, -1);
    }

    @Test
    public void should_truncate_numbers() throws Exception {
        assertThat(truncate(1.3145, 2), is(1.31));
    }

    @Test
    public void should_truncate_numbers2() throws Exception {
        assertThat(truncate(1.3145, 3), is(1.314));
    }

    @Test
    public void should_truncate_numbers3() throws Exception {
        assertThat(truncate(1.3145464648, 0), is(1.0));
    }

}

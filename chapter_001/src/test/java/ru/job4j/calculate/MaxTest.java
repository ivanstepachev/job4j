package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void whenThirdMoreSecondAndFirst() {
        Max maxim = new Max();
        int result = maxim.maxOneOfThree(1, 2, 3);
        assertThat(result, is(3));
    }

    @Test
    public void whenFirstMoreSecondAndThird() {
        Max maxim = new Max();
        int result = maxim.maxOneOfThree(4, 1, 2);
        assertThat(result, is(4));
    }

    @Test
    public void whenSecondMoreFirstAndThird() {
        Max maxim = new Max();
        int result = maxim.maxOneOfThree(4, 5, 2);
        assertThat(result, is(5));
    }
}

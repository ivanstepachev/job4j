package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UnionArrayTest {
    @Test

    public void whenIntegrateTwoArraysInOne() {
        UnionArray unionArray = new UnionArray();
        int[] inputFirst = new int[]{1, 6, 4};
        int[] inputSecond = new int[]{2, 3, 5};
        int[] result = unionArray.integrateArrays(inputFirst, inputSecond);
        int[] expect = {1, 6, 4, 2, 3, 5};
        assertThat(result, is(expect));
    }
}

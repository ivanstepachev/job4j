package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UnionArrayTest {

    @Test
    public void whenIntegrateTwoArraysWithDifferentSizeInOne() {
        UnionArray unionArray = new UnionArray();
        int[] inputFirst = new int[]{8, 9, 10};
        int[] inputSecond = new int[]{1, 2, 5, 12, 15};
        int[] result = unionArray.merge(inputFirst, inputSecond);
        int[] expect = {1, 2, 5, 8, 9, 10, 12, 15};
        assertThat(result, is(expect));
    }

    @Test
    public void whenIntegrateTwoArraysInOne() {
        UnionArray unionArray = new UnionArray();
        int[] inputFirst = new int[]{1, 3, 6};
        int[] inputSecond = new int[]{2, 4, 5};
        int[] result = unionArray.merge(inputFirst, inputSecond);
        int[] expect = {1, 2, 3, 4, 5, 6};
        assertThat(result, is(expect));
    }

    @Test
    public void whenIntegrateTwoArraysInOne2() {
        UnionArray unionArray = new UnionArray();
        int[] inputFirst = new int[]{1, 2, 7, 8};
        int[] inputSecond = new int[]{3, 5, 10};
        int[] result = unionArray.merge(inputFirst, inputSecond);
        int[] expect = {1, 2, 3, 5, 7, 8, 10};
        assertThat(result, is(expect));
    }
}

package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {

    @Test

    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = new String[] {"Hello", "World", "Hello", "Super", "World"};
        String[] result = arrayDuplicate.remove(input);
        String[] expect = new String[] {"Hello", "World", "Super"};
        assertThat(result, is(expect));
    }

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicates2() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = new String[] {"Hello", "World", "Job", "Job", "Hello", "Job", "Super", "World"};
        String[] result = arrayDuplicate.remove(input);
        String[] expect = new String[] {"Hello", "World", "Job", "Super"};
        assertThat(result, is(expect));
    }
}

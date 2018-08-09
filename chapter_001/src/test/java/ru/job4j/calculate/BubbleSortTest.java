package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        //напишите здесь тест, проверяющий сортировку массива из 10 элементов методом пузырька, например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
    BubbleSort bubbleSort = new BubbleSort();
    int[] input = new int[] {5, 3, 2, 6, 1, 9, 7, 4, 10, 8};
    int[] result = bubbleSort.sort(input);
    int[] expect = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    assertThat(result, is(expect));
     }

}

package ru.job4j.calculate;

import java.util.Arrays;

public class ArrayDuplicate {

    public String[] remove(String[] array) {
        int counter = 0;
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    for (int shiftToLeft = in + 1; shiftToLeft < unique; shiftToLeft++) { // для сдвига элементов влево
                        array[shiftToLeft - 1] = array[shiftToLeft]; // перемещаем элементы влево
                        array[unique - 1] = "ForDelete"; // задаем значение для повторяющихся элементов,перемещенных в конец
                    }  unique--;
                    in--;
                }
            }
            if (array[out].equals("ForDelete")) {
                counter++;
            }
        }
        return Arrays.copyOf(array, unique - counter);
    }
}

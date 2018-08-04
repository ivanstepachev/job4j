package ru.job4j.calculate;

public class Counter {

    public int add(int start, int finish) {
        int sumStart = 0;
        for (start = 0; start <= finish; start++) {
            if (start % 2 == 0) {
                sumStart += start;
            }
        }
     return sumStart;
    }
}






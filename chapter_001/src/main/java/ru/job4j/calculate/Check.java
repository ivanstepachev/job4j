package ru.job4j.calculate;

public class Check {

    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i != data.length; i++) {
            for (int j = i + 1; j != data.length; j++) {
                if (data[i] != data[j]) {
                    result = false;
                }
            }
        } return result;
    }
}
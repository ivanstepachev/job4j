package ru.job4j.calculate;

public class Check {

    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i != data.length; i++) {
            if (data[0] != data[i]) {
                result = false;
                break;
            }
        } return result;
    }
}
package ru.job4j.calculate;

public class UnionArray {

    public int[] integrateArrays(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        for (int i = 0; i != b.length; i++) {
            c[i] = a[i];
            c[c.length - 1 - i] = b[b.length - 1 - i];
        }
        return c;
    }
}


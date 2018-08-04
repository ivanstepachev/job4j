package ru.job4j.calculate;

public class Factorial {

   public int calc(int n) {
        int i;
        int fact = 1;
        for (i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
   }
}


package ru.job4j.calculate;

/**
 * Корвертор валюты.
 */
public class Converter {

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        int rubleToEuro = value / 70;
        return rubleToEuro;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        int rubleToDollar = value / 60;
        return rubleToDollar;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return Рубли
     */
    public int euroToRuble(int value) {
        int euroToRuble = value * 70;
        return euroToRuble;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return Рубли
     */
     public int dollarToRuble(int value) {
        int dollarToRuble = value * 60;
        return dollarToRuble;
    }
}


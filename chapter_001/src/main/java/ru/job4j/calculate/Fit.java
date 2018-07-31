package ru.job4j.calculate;

/**
 * Программа для расчета идеального веса.
 */
public class Fit {

    /**
     * Идеальный вес для мужчины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double manWeight(double height) {
        double manWeight = (height - 100) * 1.15;
        return manWeight;
    }

    /**
     * Идеальный вес для женщины.
     * @param height Рост.
     * @return идеальный вес.
     */

    public double womanWeight(double height) {
        double womanHeight = (height - 110) * 1.15;
        return womanHeight;
    }
}

package ru.job4j.calculate;

/**
 * @author Ivan Stepachev (mailto:i1nes@icloud.com)
 * @version $Id$
 * @since 0.1
 */
public class Max {

    /**
     * Определяет наибольшее число из двух вариантов.
     *
     * @param first  Первое число.
     * @param second Второе число.
     * @return Наибольшее число.
     */
    public int maxOneOfTwo(int first, int second) {
        return first > second ? first : second;
    }
    /**
     * Определяет наибольшее число из трех вариантов.
     *
     * @param first  Первое число.
     * @param second Второе число.
     * @param third Третье число.
     * @return Наибольшее число.
     */
    public int maxOneOfThree(int first, int second, int third) {
        return this.maxOneOfTwo(this.maxOneOfTwo(first, second), third);
    }
}

package ru.job4j.calculate;

/**
 * @author Ivan Stepachev (mailto:i1nes@icloud.com)
 * @version $Id$
 * @since 0.1
 */
public class Max {

    /** Отвечает на вопросы.
     * @param first Первое число.
     * @param second Второе число.
     * @return Наибольшее число.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}

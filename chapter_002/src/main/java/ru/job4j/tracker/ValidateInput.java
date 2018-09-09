package ru.job4j.tracker;

import java.util.List;

/**
 * @author Ivan Stepachev(mailto:i1nes@icloud.com)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Метод, реализующий выброс исключения на выход из диапазона значений меню или ввода неккоректного символа.
     *
     * @param question вопрос, заданынй пользователю
     * @param range    массив, хранящий диапазон значений меню.
     * @return ответ пользователя
     */
    @Override
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Введите корректный номер меню. ");
            } catch (NumberFormatException nfe) {
                System.out.println("Введите значение повторно. ");
            }
        } while (invalid);
        return value;
    }
}

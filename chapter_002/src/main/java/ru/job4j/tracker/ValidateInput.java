package ru.job4j.tracker;

import java.util.List;

/**
 * @author Ivan Stepachev(mailto:i1nes@icloud.com)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }
    /**
     * Метод, реализующий выброс исключения на выход из диапазона значений меню или ввода неккоректного символа.
     *
     * @param question вопрос, заданынй пользователю
     * @param range    массив, хранящий диапазон значений меню.
     * @return ответ пользователя
     */
    @Override
    public int ask(String question, List<Integer> range) {
        int key = this.input.ask(question, range);
        if (!range.contains(key)) {
            throw new MenuOutException("Введите корректный номер меню. ");
        }
        return key;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }
}

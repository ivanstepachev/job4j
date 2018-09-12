package ru.job4j.tracker;

import java.util.*;

/**
 * @author Ivan Stepachev(mailto:i1nes@icloud.com)
 * @version $Id$
 * @since 0.1
 */
public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Метод реализует консольный ввод от пользователя
     *
     * @param question вопрос, заданынй пользователю
     * @return ответ пользователя
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    /**
     * Метод, реализующий проверку на выход из диапазона значений меню.
     *
     * @param question вопрос, заданынй пользователю
     * @param range    массив, хранящий диапазон значений меню.
     * @return выбранное значение
     */
    public int ask(String question, List<Integer> range) {
        return Integer.valueOf(this.ask(question));
    }
}

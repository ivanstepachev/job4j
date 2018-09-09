package ru.job4j.tracker;
/**
 * @author Ivan Stepachev(mailto:i1nes@icloud.com)
 * @version $Id$
 * @since 0.1
 */
public interface UserAction {
    /**
     * Метод возвращает ключ опции.
     *
     * @return ключ
     */
    int key();
    /**
     * Метод, реализующий действия пользователя
     *
     * @param input   instance of Input
     * @param tracker instance of Tracker
     */
    void execute(Input input, Tracker tracker);
    /**
     * Метод возвращает информацию о данном пункте меню
     *
     * @return Строка меню
     */
    String info();
}

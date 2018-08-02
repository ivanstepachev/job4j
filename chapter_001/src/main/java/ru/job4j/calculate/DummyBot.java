package ru.job4j.calculate;

/**
 * @author Ivan Stepachev (mailto:i1nes@icloud.com)
 * @version $Id$
 * @since 0.1
 */
public class DummyBot {
    /** Отвечает на вопросы.
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String rs1 = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rs1 = "Привет, умник.";
        }  else if ("Пока.".equals(question)) {
            rs1 = "До скорой встречи.";
        }
        return rs1;

    }
}

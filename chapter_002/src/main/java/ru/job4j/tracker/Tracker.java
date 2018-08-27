package ru.job4j.tracker;

import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {

    /**
     * Массив для хранения заявок
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки
     */
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод реализующий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описания. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод, реализующий удаление заявки в хранилище по id.
     * @param id уникальный ключ заявки
     */
    public void delete(String id) {
        for (int index = 0; index < this.position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                System.arraycopy(this.items, index + 1, items, index, position - index);
                position--;
                break;
            }
        }
    }

    /**
     * Метод, реализующий вывод всех созданных заявок.
     * @return все созданные заяки, без null элементов.
     */
    public Item[] findAll() {
    Item[] result = new Item[this.position];
    for (int index = 0; index < this.position; index++) {
        result[index] = this.items[index];
    }
    return result;
    }

    /**
     * Метод, реализующий поиск заявки по имени.
     * @param key имя по которому осуществляем поиск
     * @return заявку, найденную по имени
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[1];
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getName() != null && this.items[index].getName().equals(key)) {
                result[0] = this.items[index];
                break;
            }
        }
        return result;
    }

    /**
     * Метод, реализующий поиск заявки по уникальному номеру.
     * @param id уникальный номер, по которому осуществляем поиск
     * @return заявку, найденную по имени
     */
    public Item findById(String id) {
        Item result = null;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                result = this.items[index];
                break;
            }
        } return result;
    }

    /**
     * Метод, реализующий замену уже созданной заявки на другую.
     * @param id уникальный номер заявки, которую мы заменяем.
     * @param item заявкаЮ на которую мы заменяем
     */
    public void replace(String id, Item item) {
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                this.items[index].setName(item.getName());
                this.items[index].setDesc(item.getDesc());
                this.items[index].setCreated(item.getCreated());
                break;
            }
        }
    }
}

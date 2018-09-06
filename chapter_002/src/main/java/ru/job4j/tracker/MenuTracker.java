package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект
     */
    private Input input;
    /**
     * @param хранит ссылку на объект
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();
    /**
     * Конструктор
     *
     * @param input   instance of Input
     * @param tracker instance of Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Метод для получения массива меню
     *
     * @return длина массива
     */
    public int getActionLength() {
        return this.actions.size();
    }
    /**
     * Метод заполняет массив
     */
    public void fillActions() {
        this.actions.add(new AddItem());
        this.actions.add(new ShowItems());
        this.actions.add(new MenuTracker.EditItem());
        this.actions.add(new MenuTracker.DeleteItem());
        this.actions.add(new FindItemById());
        this.actions.add(new FindItemByName());
        this.actions.add(new ExitProgram());
    }
    /**
     * Метод в зависимости от указанного ключа, выполняет соответсующие действия
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }
    /**
     * Метод выводит на экран меню
     */
    public void show() {
        for (UserAction action : actions) {
            if (action != null) {
                System.out.println(action.key() + ". " + action.info());
            }
        }
    }
    /**
     * Класс, реализующий добавление заявки
     */
    public class AddItem implements UserAction {

        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с Id : " + item.getId() + " создана  -----------");
        }

        @Override
        public String info() {
            return "Создать новую заявку";
        }
    }
    /**
     * Класс, реализующий вызов всех заявок
     */
    public class ShowItems implements UserAction {

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] items = tracker.findAll();
            for (Item item : items) {
                System.out.println("------------ Имя заявки : " + item.getName() + " ; Описаение заявки : " + item.getDesc() + " ------------");
            }
        }

        @Override
        public String info() {
            return "Показать все заявки";
        }
    }
    /**
     * Класс, реализующий редактирование заявки
     */
    public static class EditItem implements UserAction {

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Изменение заявки --------------");
            String id = input.ask("Введите id изменяемой заявки :");
            String name = input.ask("Введите новое имя :");
            String desc = input.ask("Введите новое описание :");
            Item item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                System.out.println("------------ Отредактированная заявка : " + item.toString() + " -----------");
            } else {
                System.out.println(" Заявка не найдена ");
            }
        }

        @Override
        public String info() {
            return "Отредактировать заявку";
        }
    }
    /**
     * Класс, реализующий удаление заявки
     */
    public static class DeleteItem implements UserAction {

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите id заявки :");
            if (tracker.delete(id)) {
                System.out.println("------------ Заявка с id : " + id + " удалена-----------");
            } else {
                System.out.println(" Заявка не может быть удалена, потому что заявки с данным id не существует. Введите корректый id. ");
            }
        }

        @Override
        public String info() {
            return "Удалить заявку";
        }
    }
    /**
     * Класс, реализующий поиск по ID
     */
    public class FindItemById implements UserAction {

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по ID --------------");
            String id = input.ask("Введите id заявки :");
            if (tracker.findById(id) != null) {
                System.out.println("------------ Заявка с id " + id + " : " + tracker.findById(id));
            } else {
                System.out.println("------------ Заявка с id " + id + " не найдена. Введите корректный номер.");
            }
        }

        @Override
        public String info() {
            return "Найти заявку по Id";
        }
    }
    /**
     * Класс, реализующий поиск по имени
     */
    public class FindItemByName implements UserAction {

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени --------------");
            String name = input.ask("Введите имя заявки :");
            Item[] result = tracker.findByName(name);
            if (result.length > 0) {
                for (int i = 0; i < result.length; i++) {
                    System.out.println(" Заявка с именем " + name + " № " + (i + 1) + " " + result[i].toString());
                }
            } else {
                System.out.println(" Заявка с таким именем не найдена. Введите корректное имя.");
            }
        }

        @Override
        public String info() {
            return "Найти заявку по имени";
        }
    }
    /**
     * Класс, реализующий выход из программы
     */
    public class ExitProgram implements UserAction {

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Выход из программы --------------");
            System.exit(0);
        }

        @Override
        public String info() {
            return "Выйти из программы";
        }
    }

}


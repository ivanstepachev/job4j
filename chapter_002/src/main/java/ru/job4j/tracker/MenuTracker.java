package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Stepachev(mailto:i1nes@icloud.com)
 * @version $Id$
 * @since 0.1
 */
public class MenuTracker {
    /**
     * Хранит диапазон значений меню.
     */
    private List<Integer> ranges = new ArrayList<>();
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
     * Метод реализующий увеличение диапазона значений меню
     *
     * @return коллекция значений меню
     */
    public List<Integer> rangesLength() {
        for (int i = 0; i < this.getActionLength(); i++) {
            ranges.add(i);
        }
        return ranges;
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
    public void fillActions(StartUI startUI) {
        this.actions.add(new AddItem(0, "Создать новую заявку"));
        this.actions.add(new ShowItems(1, "Показать все заявки"));
        this.actions.add(new MenuTracker.EditItem(2, "Отредактировать заявку"));
        this.actions.add(new MenuTracker.DeleteItem(3, "Удалить заявку"));
        this.actions.add(new FindItemById(4, "Найти заявку по Id"));
        this.actions.add(new FindItemByName(5, "Найти заявку по имени"));
        this.actions.add(new ExitProgram(6, "Выйти из программы", startUI));
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

        private int keyNumber;
        private String menuOption;

        public AddItem(int keyNumber, String menuOption) {
            this.keyNumber = keyNumber;
            this.menuOption = menuOption;
        }

        @Override
        public int key() {
            return keyNumber;
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
            return menuOption;
        }
    }

    /**
     * Класс, реализующий вызов всех заявок
     */
    public class ShowItems implements UserAction {

        private int keyNumber;
        private String menuOption;

        public ShowItems(int keyNumber, String menuOption) {
            this.keyNumber = keyNumber;
            this.menuOption = menuOption;
        }

        @Override
        public int key() {
            return keyNumber;
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
            return menuOption;
        }
    }

    /**
     * Класс, реализующий редактирование заявки
     */
    public static class EditItem implements UserAction {

        private int keyNumber;
        private String menuOption;

        public EditItem(int keyNumber, String menuOption) {
            this.keyNumber = keyNumber;
            this.menuOption = menuOption;
        }

        @Override
        public int key() {
            return keyNumber;
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
            return menuOption;
        }
    }

    /**
     * Класс, реализующий удаление заявки
     */
    public static class DeleteItem implements UserAction {

        private int keyNumber;
        private String menuOption;

        public DeleteItem(int keyNumber, String menuOption) {
            this.keyNumber = keyNumber;
            this.menuOption = menuOption;
        }

        @Override
        public int key() {
            return keyNumber;
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
            return menuOption;
        }
    }

    /**
     * Класс, реализующий поиск по ID
     */
    public class FindItemById implements UserAction {

        private int keyNumber;
        private String menuOption;

        public FindItemById(int keyNumber, String menuOption) {
            this.keyNumber = keyNumber;
            this.menuOption = menuOption;
        }

        @Override
        public int key() {
            return keyNumber;
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
            return menuOption;
        }
    }

    /**
     * Класс, реализующий поиск по имени
     */
    public class FindItemByName implements UserAction {

        private int keyNumber;
        private String menuOption;

        public FindItemByName(int keyNumber, String menuOption) {
            this.keyNumber = keyNumber;
            this.menuOption = menuOption;
        }

        @Override
        public int key() {
            return keyNumber;
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
            return menuOption;
        }
    }

    /**
     * Класс, реализующий выход из программы
     */
    public class ExitProgram implements UserAction {

        private StartUI startUI;

        private int keyNumber;
        private String menuOption;

        public ExitProgram(int keyNumber, String menuOption, StartUI startUI) {
            this.keyNumber = keyNumber;
            this.menuOption = menuOption;
            this.startUI = startUI;
        }

        @Override
        public int key() {
            return keyNumber;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Выход из программы --------------");
            this.startUI.stop();
        }

        @Override
        public String info() {
            return menuOption;
        }
    }

}


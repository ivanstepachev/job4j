package ru.job4j.tracker;


/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    private static final String EXIT = "6";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDBYID = "4";
    private static final String FINDBYNAME = "5";
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAllItems();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDBYID.equals(answer)) {
                this.itemById();
            } else if (FINDBYNAME.equals(answer)) {
                this.itemByName();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод показывает все заявки.
     */
    private void showAllItems() {
        Item[] items = this.tracker.findAll();
        for(Item item : items)
        System.out.println("------------ Имя заявки : " + item.getName() + " ; Описаение заявки : " + item.getDesc() + " ------------");
    }

    /**
     * Метод реализует редактирование заявки.
     */
    private void editItem() {
        System.out.println("------------ Изменение заявки --------------");
        String id = this.input.ask("Введите id изменяемой заявки :");
        String name = this.input.ask("Введите новое имя :");
        String desc = this.input.ask("Введите новое описание :");
        Item item = new Item(name, desc);
        if (this.tracker.replace(id, item)) {
            System.out.println("------------ Отредактированная заявка : " + item.toString() + " -----------");
        } else {
            System.out.println(" Заявка не найдена ");
        }
    }

    /**
     * Метод реализует поиск заявки по name.
     */
    private void itemByName() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите имя заявки :");
        Item[] result = this.tracker.findByName(name);
        if (result.length > 0) {
            for (int i = 0; i < result.length; i++) {
                System.out.println(" Заявка с именем " + name + " № " + (i + 1) + " " + result[i].toString());
            }
        } else {
            System.out.println(" Заявка с таким именем не найдена. Введите корректное имя.");
        }
    }

    /**
     * Метод реализует поиск заявки по id.
     */
    private void itemById() {
        System.out.println("------------ Поиск заявки по ID --------------");
        String id = this.input.ask("Введите id заявки :");
        if (this.tracker.findById(id) != null) {
            System.out.println("------------ Заявка с id " + id + " : " + this.tracker.findById(id));
        } else {
            System.out.println("------------ Заявка с id " + id + " не найдена. Введите корректный номер.");
        }
    }

    /**
     * Метод реализует удаление заявки в хранилище.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        if (this.tracker.delete(id)) {
            System.out.println("------------ Заявка с id : " + id + " удалена-----------");
        } else {
            System.out.println(" Заявка не может быть удалена, потому что заявки с данным id не существует. Введите корректый id. ");
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с Id : " + item.getId() + " создана  -----------");
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Создать новую заявку");
        System.out.println("1. Показать все заявки");
        System.out.println("2. Отредактировать заявку");
        System.out.println("3. Удалить заявку");
        System.out.println("4. Найти заявку по Id");
        System.out.println("5. Найти заявку по имени");
        System.out.println("6. Выйти из программы");
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}

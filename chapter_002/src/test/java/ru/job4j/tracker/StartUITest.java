package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Ivan Stepachev(mailto:i1nes@icloud.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUITest {

    private final Tracker tracker = new Tracker();
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final StringBuilder menu = new StringBuilder()
            .append("0. Создать новую заявку")
            .append(System.lineSeparator())
            .append("1. Показать все заявки")
            .append(System.lineSeparator())
            .append("2. Отредактировать заявку")
            .append(System.lineSeparator())
            .append("3. Удалить заявку")
            .append(System.lineSeparator())
            .append("4. Найти заявку по Id")
            .append(System.lineSeparator())
            .append("5. Найти заявку по имени")
            .append(System.lineSeparator())
            .append("6. Выйти из программы")
            .append(System.lineSeparator());


    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);

    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker trackerAfter = new Tracker();
        Item itemFirst = tracker.add(new Item("test name1", "desc1"));
        Item itemSecond = tracker.add(new Item("test name2", "desc2"));
        Item itemThird = tracker.add(new Item("test name3", "desc3"));
        trackerAfter.add(itemFirst);
        trackerAfter.add(itemThird);
        Input input = new StubInput(new String[]{"3", itemSecond.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(trackerAfter.findAll()));
    }

    @Test
    public void whenFindByNameInConsole() {
        Item item = tracker.add(new Item("test1", "desc1"));
        Input input = new StubInput(new String[]{"5", "test1", "y"});
        new StartUI(input, tracker).init();
        assertThat(item.getName(), is("test1"));
    }

    @Test
    public void whenUserChooseShowAll() {
        Item itemFirst = new Item("test1", "desc1");
        Item itemSecond = new Item("test2", "desc2");
        Item itemThird = new Item("test3", "desc3");
        tracker.add(itemFirst);
        tracker.add(itemSecond);
        tracker.add(itemThird);
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(new StringBuilder()
                        .append(menu)
                        .append("------------ Имя заявки : " + itemFirst.getName() + " ; Описаение заявки : " + itemFirst.getDesc() + " ------------")
                        .append(System.lineSeparator())
                        .append("------------ Имя заявки : " + itemSecond.getName() + " ; Описаение заявки : " + itemSecond.getDesc() + " ------------")
                        .append(System.lineSeparator())
                        .append("------------ Имя заявки : " + itemThird.getName() + " ; Описаение заявки : " + itemThird.getDesc() + " ------------")
                        .append(System.lineSeparator())
                        .toString()));
    }

    @Test
    public void whenUserChooseFindByName() {
        Item itemFirst = tracker.add(new Item("test1", "desc1"));
        Item itemSecond = tracker.add(new Item("test1", "desc2"));
        Item itemThird = tracker.add(new Item("test3", "desc3"));
        Input input = new StubInput(new String[]{"5", "test1", "y"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(new StringBuilder().append(menu)
                        .append("------------ Поиск заявки по имени --------------")
                        .append(System.lineSeparator())
                        .append(" Заявка с именем test1 № 1 " + itemFirst.toString())
                        .append(System.lineSeparator())
                        .append(" Заявка с именем test1 № 2 " + itemSecond.toString())
                        .append(System.lineSeparator())
                        .toString()));
    }

    @Test
    public void whenUserChooseFindByNameButNoCoincidence() {
        Item itemFirst = tracker.add(new Item("test1", "desc1"));
        Item itemSecond = tracker.add(new Item("test2", "desc2"));
        Item itemThird = tracker.add(new Item("test3", "desc3"));
        Input input = new StubInput(new String[]{"5", "test4", "y"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(new StringBuilder().append(menu)
                        .append("------------ Поиск заявки по имени --------------")
                        .append(System.lineSeparator())
                        .append(" Заявка с таким именем не найдена. Введите корректное имя.")
                        .append(System.lineSeparator())
                        .toString()));
    }

    @Test
    public void whenUserChooseFindById() {
        Item itemFirst = tracker.add(new Item("test1", "desc1"));
        Item itemSecond = tracker.add(new Item("test2", "desc2"));
        Input input = new StubInput(new String[]{"4", itemFirst.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(new StringBuilder().append(menu)
                        .append("------------ Поиск заявки по ID --------------")
                        .append(System.lineSeparator())
                        .append("------------ Заявка с id " + itemFirst.getId() + " : " + tracker.findById(itemFirst.getId()))
                        .append(System.lineSeparator())
                        .toString()));
    }
}

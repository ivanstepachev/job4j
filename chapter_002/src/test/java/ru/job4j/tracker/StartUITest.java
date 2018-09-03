package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Tracker trackerAfter = new Tracker();
        Item itemFirst = tracker.add(new Item("test name1", "desc1"));
        Item itemSecond = tracker.add(new Item("test name2", "desc2"));
        Item itemThird = tracker.add(new Item("test name3", "desc3"));
        trackerAfter.add(itemFirst);
        trackerAfter.add(itemThird);
        Input input = new StubInput(new String[]{"3", itemSecond.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(trackerAfter.findAll()));
    }

}

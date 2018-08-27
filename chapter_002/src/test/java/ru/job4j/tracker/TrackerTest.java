package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {

   @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Item itemOne = new Item("test1", "TestDescription1", 123L);
        Item itemTwo = new Item("test2", "TestDescription2", 234L);
        Item itemThree = new Item("test3", "TestDescription3", 555L);
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        Item[] expect = {itemOne, itemTwo, itemThree};
        Item[] result = tracker.findAll();
        assertThat(result, is(expect));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item itemOne = new Item("test1", "TestDescription1", 123L);
        Item itemTwo = new Item("test2", "TestDescription2", 234L);
        Item itemThree = new Item("test3", "TestDescription3", 555L);
        Item itemFour = new Item("test4", "TestDescription4", 3234L);
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        tracker.add(itemFour);
        Item[] expect = {itemTwo};
        Item[] result = tracker.findByName("test2");
        assertThat(result, is(expect));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item itemOne = new Item("name1", "TestDescription1", 123L);
        Item itemTwo = new Item("name2", "TestDescription2", 234L);
        Item itemThree = new Item("name3", "TestDescription3", 555L);
        Item itemFour = new Item("name4", "TestDescription4", 3234L);
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        tracker.add(itemFour);
        itemOne.setId("1");
        itemTwo.setId("2");
        itemThree.setId("3");
        itemFour.setId("4");
        Item expect = itemTwo;
        Item result = tracker.findById("2");
        assertThat(result, is(expect));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription1", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDelete() {
        Tracker actual = new Tracker();
        Tracker result = new Tracker();
        Item first = new Item("test1", "testDescription1", 123L);
        Item second = new Item("test2", "testDescription2", 1234L);
        Item third = new Item("test3", "testDescription3", 12345L);
        Item fourth = new Item("test4", "testDescription4", 12346L);
        Item fifth = new Item("test5", "testDescription5", 12347L);
        actual.add(first);
        actual.add(second);
        actual.add(third);
        actual.add(fourth);
        actual.add(fifth);
        result.add(first);
        result.add(second);
        result.add(fourth);
        result.add(fifth);
        actual.delete(third.getId());
        assertThat(actual.findAll(), is(result.findAll()));
    }
}

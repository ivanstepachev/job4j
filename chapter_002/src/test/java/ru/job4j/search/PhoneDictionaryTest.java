package ru.job4j.search;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("87");
        assertThat(persons.iterator().next().getName(), is("Petr"));
    }

    @Test
    public void whenFindBySurname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("sent");
        assertThat(persons.iterator().next().getName(), is("Petr"));
    }

    @Test
    public void whenFindByAdress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("Bry");
        assertThat(persons.iterator().next().getName(), is("Petr"));
    }

    @Test
    public void whenFindByNameTwoPersons() {
        PhoneDictionary phones = new PhoneDictionary();
        Person person1 = new Person("Petr", "Arsentev", "534872", "Bryansk");
        Person person2 = new Person("Fedor", "Smirnov", "111111", "Moscow");
        Person person3 = new Person("Petr", "Ivanov", "999999", "Kaluga");
        Person person4 = new Person("Nick", "Avdeev", "000000", "Krasnodar");
        phones.add(person1);
        phones.add(person2);
        phones.add(person3);
        phones.add(person4);
        List<Person> persons = phones.find("Petr");
        ArrayList<Person> expect = new ArrayList<Person>() { {
            add(person1);
            add(person3);
        } };
        assertThat(persons, is(expect));
    }
}

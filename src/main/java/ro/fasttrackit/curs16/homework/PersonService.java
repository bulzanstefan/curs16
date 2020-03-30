package ro.fasttrackit.curs16.homework;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class PersonService {
    private List<Person> persons;
    private int idCounter = 0;

    public PersonService() {
        persons = new ArrayList<>();
    }

    public List<Person> getAllPersons() {
        return unmodifiableList(persons);
    }

    public Person addPerson(Person person) {
        var personToAdd = new Person(++idCounter, person.getName(), person.getAge());
        persons.add(personToAdd);
        return personToAdd;
    }

    public Person removePerson(int id) {
        Person toDelete = findPersonById(id);
        if (toDelete != null) {
            persons.remove(toDelete);
            return toDelete;
        } else {
            throw new IllegalArgumentException("Person doesn't exist");
        }
    }

    private Person findPersonById(int id) {
        for (Person person : persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public List<Person> getPersonsOlderThan(final int age) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getAge() >= age) {
                result.add(person);
            }
        }
        return result;
    }
}

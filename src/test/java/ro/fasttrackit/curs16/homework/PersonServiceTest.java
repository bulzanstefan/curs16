package ro.fasttrackit.curs16.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static org.junit.jupiter.api.Assertions.assertThrows;


class PersonServiceTest {
    PersonService personService;

    @BeforeEach
    void setup() {
        personService = new PersonService();
    }

    @Test
    @DisplayName("WHEN creating a PersonService THEN it will have empty person list")
    void emptyPersonService() {

        assertThat(personService.getAllPersons()).isEmpty();
    }

    @Test
    @DisplayName("WHEN a person is added THEN the size is increased and ID is set")
    void addPerson() {
        Person result = personService.addPerson(new Person(-1, "Mihai", 23));

        assertThat(personService.getAllPersons()).hasSize(1);
        assertThat(result.getId()).isEqualTo(1);
    }

    @Test
    @DisplayName("WHEN multiple persons are added THEN the size increases and ID are set correctly")
    void addMultiplePersons() {
        personService.addPerson(new Person(-1, "Mihai", 23));
        var secondPerson = personService.addPerson(new Person(-2, "Mihaitza", 43));

        assertThat(personService.getAllPersons()).hasSize(2);
        assertThat(secondPerson.getId()).isEqualTo(2);
    }

    @Test
    @DisplayName("WHEN the existing person is deleted THEN the person is deleted")
    void deleteExistingPerson() {
        personService.addPerson(new Person(1, "Mihai", 22));
        personService.addPerson(new Person(2, "Mihai", 22));
        personService.addPerson(new Person(3, "Mihai", 22));

        Person deletedPerson = personService.removePerson(1);

        assertThat(deletedPerson.getId()).isEqualTo(1);
        assertThat(personService.getAllPersons()).hasSize(2);
    }

    @Test
    @DisplayName("WHEN the existing person is deleted THEN the person is deleted")
    void deleteNonExistingPerson() {
        personService.addPerson(new Person(1, "Mihai", 22));
        personService.addPerson(new Person(2, "Mihai", 22));
        personService.addPerson(new Person(3, "Mihai", 22));

        var exception = assertThrows(IllegalArgumentException.class, () -> personService.removePerson(20));
        assertThat(exception.getMessage()).isEqualTo("Person doesn't exist");
        assertThat(personService.getAllPersons()).hasSize(3);
    }

    @Test
    @DisplayName("WHEN we request persons older than an age THEN only those persons are returned")
    void getPersonsOlderThan() {
        personService.addPerson(new Person(1, "Mihai Primu", 22));
        personService.addPerson(new Person(2, "Mihai Alu' Doilea", 42));
        personService.addPerson(new Person(3, "Mihai Treila", 62));

        List<Person> older = personService.getPersonsOlderThan(30);

        assertThat(older).hasSize(2);
        assertThat(older)
                .extracting("id", "name")
                .containsExactly(tuple(2, "Mihai Alu' Doilea"), tuple(3, "Mihai Treila"));
    }

    @Test
    @DisplayName("WHEN we request persons older than an age and they don't exist THEN empty list")
    void getPersonsOlderThanNotExisting() {
        personService.addPerson(new Person(1, "Mihai Primu", 22));
        personService.addPerson(new Person(2, "Mihai Alu' Doilea", 42));
        personService.addPerson(new Person(3, "Mihai Treila", 62));

        List<Person> older = personService.getPersonsOlderThan(70);

        assertThat(older).isEmpty();
    }
}

package ro.fasttrackit.curs16.homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonTest {

    @Test
    @DisplayName("WHEN a simple person is created THEN no exceptions are thrown")
    void simplePerson() {
        //SETUP
        //RUN
        Person person = new Person(133, "Mihai Popescu", 30);
        //ASSERT
        assertThat(person.getId()).isEqualTo(133);
        assertThat(person.getName()).isEqualTo("Mihai Popescu");
        assertThat(person.getAge()).isEqualTo(30);
    }

    @Test
    @DisplayName("WHEN name is null THEN IllegalArgumentException is thrown")
    void nullNamePerson() {
        //SETUP
        //RUN
        var exception = assertThrows(IllegalArgumentException.class, () -> new Person(1, null, 33));
        //ASSERT
        assertThat(exception.getMessage()).isEqualTo("Invalid name: null is not allowed");
    }

    @Test
    @DisplayName("WHEN name contains numbers THEN IllegalArgumentException is thrown")
    void numbersInName() {
        //SETUP
        //RUN
        var exception = assertThrows(IllegalArgumentException.class, () -> new Person(1, "PopescuIsNr1", 33));
        //ASSERT
        assertThat(exception.getMessage()).isEqualTo("Invalid name");
    }

    @Test
    @DisplayName("WHEN name contains illegal chars THEN IllegalArgumentException is thrown")
    void specialCharInName() {
        //SETUP
        //RUN
        var exception = assertThrows(IllegalArgumentException.class, () -> new Person(1, "#Emma", 33));
        //ASSERT
        assertThat(exception.getMessage()).isEqualTo("Invalid name");
    }

    @Test
    @DisplayName("WHEN name contains ' or - THEN it is accepted")
    void specialName() {
        //SETUP
        //RUN
        var response = new Person(1, "Michael-Douglas O'Brian", 33);
        //ASSERT
        assertThat(response)
                .extracting("name", "age")
                .containsExactly("Michael-Douglas O'Brian", 33);
    }

    @Test
    @DisplayName("WHEN age is less than 0 or greater than 120 THEN IllegalArgumentException is thrown")
    void invalidAge() {
        var exceptions = assertThrows(IllegalArgumentException.class, () -> new Person(1, "Mihai", -1));

        assertThat(exceptions.getMessage()).isEqualTo("Invalid age: 0 -> 120");
    }
}

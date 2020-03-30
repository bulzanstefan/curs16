package ro.fasttrackit.curs16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Integer.MAX_VALUE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("WHEN I add two positive integers THEN their sum is returned")
    void addingTwoPositive() {
        //SETUP

        //RUN
        var result = calculator.add(1, 2);
        //ASSERT
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("WHEN I add a positive and a negative number THEN their difference is returned")
    void addingPositiveAndNegative() {
        //SETUP

        //RUN
        var result = calculator.add(1, -1);
        //ASSERT
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("WHEN adding a number to the max integer THEN throw exception")
    void addingToMaxInteger() {
        //SETUP

        //RUN + ASSERT
        assertThrows(IllegalArgumentException.class, () -> calculator.add(MAX_VALUE, 10));
    }


    @Test
    @DisplayName("WHEN substracting two positive numbers THEN their difference is returned")
    void substractingTwoPositive() {
        // SETUP

        // RUN
        var result = calculator.substract(10, 3);

        //ASSERT
        assertThat(result).isEqualTo(7);
    }

    @Test
    @DisplayName("WHEN subsctracting from -MAX_INT THEN exception is thrown")
    void substractMinusMaxInt() {
        //SETUP

        //RUN
        try {
            calculator.substract(-MAX_VALUE, 10);
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException iae) {
            assertTrue(true);
        }
    }

    @Test
    @DisplayName("WHEN a number is multiplied with 1 THEN that number is returned")
    void multiplyPositiveWith1() {
        //SETUP

        //RUN
        var result = calculator.multiply(7, 1);

        //ASSERT
        assertThat(result).isEqualTo(7);
    }

    @Test
    @DisplayName("WHEN two numbers are multiplied THEN their multiplication is returned")
    void multiplyPositive() {
        //SETUP

        //RUN
        var result = calculator.multiply(7, 7);

        //ASSERT
        assertThat(result).isEqualTo(49);
    }

    @Test
    @DisplayName("WHEN MAX_INT is multiplied with other than 1,-1 and 0 THEN exception is thrown")
    void multiplyMaxInt() {
        //SETUP

        //RUN + ASSERT
        assertThrows(IllegalArgumentException.class, () -> calculator.multiply(MAX_VALUE, 7));
    }
}

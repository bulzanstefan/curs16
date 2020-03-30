package ro.fasttrackit.curs16;

import static java.lang.Integer.MAX_VALUE;

public class Calculator {
    public int add(int a, int b) {
        if ((long) a + b > MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        return a + b;
    }

    public int substract(int a, int b) {
        if ((long) a - b < -MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        return a - b;
    }

    public int multiply(int a, int b) {
        if ((long) a * b > MAX_VALUE) {
            throw new IllegalArgumentException();
        }

        return a * b;
    }
}

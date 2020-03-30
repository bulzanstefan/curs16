package ro.fasttrackit.curs16.homework;

public class PersonValidator {

    private void verifyAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Invalid age: 0 -> 120");
        }
    }

    private void verifyName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Invalid name: null is not allowed");
        }
        for (char letter : name.toCharArray()) {
            if (!Character.isAlphabetic(letter) && !Character.isWhitespace(letter) && letter != '-' && letter != '\'') {
                throw new IllegalArgumentException("Invalid name");
            }
        }
    }

    public void verify(final String name, final int age) {
        verifyAge(age);
        verifyName(name);
    }
}

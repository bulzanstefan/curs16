package ro.fasttrackit.curs16;

import java.util.Stack;

import static java.lang.Character.isWhitespace;

public class Palindrome {

    public boolean isPalindrome(String phrase) {
        if (phrase == null) {
            return false;
        } else if (phrase.length() <= 1) {
            return true;
        } else {
            String noSpacePhrase = eliminateSpaces(phrase);
            return noSpacePhrase.equalsIgnoreCase(reverse(noSpacePhrase));
        }
    }

    private String eliminateSpaces(String phrase) {
        StringBuilder sb = new StringBuilder();
        for (char chr : phrase.toCharArray()) {
            if (!isWhitespace(chr)) {
                sb.append(chr);
            }
        }
        return sb.toString();
    }

    private String reverse(String phrase) {
        var stack = new Stack<>();
        for (Character chr : phrase.toCharArray()) {
            stack.push(chr);
        }
        String result = "";
        while (!stack.empty()) {
            result += stack.pop();
        }
        return result;
    }
}

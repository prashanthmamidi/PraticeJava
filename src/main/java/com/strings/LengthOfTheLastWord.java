package com.strings;

public class LengthOfTheLastWord {
    public int lengthOfTheLastWord(String input) {
        String[] strings = input.split("\\s");
        return strings[strings.length - 1].length();
    }
}

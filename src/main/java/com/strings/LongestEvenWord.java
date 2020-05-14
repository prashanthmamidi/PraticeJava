package com.strings;

import java.util.Arrays;
import java.util.Comparator;

public class LongestEvenWord {
    public String longestEvenWord(String str) {
        return Arrays.stream(str.split("\\s"))
                .filter(word -> word.length() % 2 == 0)
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }
}

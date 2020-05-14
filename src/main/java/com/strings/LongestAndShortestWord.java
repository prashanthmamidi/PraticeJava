package com.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class LongestAndShortestWord {
    private static final String SPACE = "\\s";

    public Object[] getLongestWord(String input) {
        if (Objects.isNull(input)) {
            throw new InvalidInputException("the input is invalid");
        }

        String[] split = input.split(SPACE);
        final String longestWord =
                Arrays.stream(split)
                        .max(Comparator.comparingInt(String::length))
//                        .max(Comparator.comparingInt(s -> s.length()))
                        .orElse("");
        return new Object[]{longestWord, longestWord.length()};
    }

    public Object[] getShortestWord(String input) {

        final String shortestWord = Arrays.stream(input.split(SPACE))
//                .sorted(Comparator.comparingInt(String::length))
//                .findFirst()
                .min(Comparator.comparingInt(String::length))
                .orElse("");

        return new Object[]{shortestWord, shortestWord.length()};
    }

    public static void main(String[] args) {
        System.out.println("frf");
    }
}

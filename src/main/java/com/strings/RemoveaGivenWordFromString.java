package com.strings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveaGivenWordFromString {
    public Object removeWord(String input, String word) {
        String[] words = input.split("\\s");

        return Arrays.stream(words)
                .filter(w -> !w.equalsIgnoreCase(word))
                .collect(Collectors.joining(" "));

    }
}

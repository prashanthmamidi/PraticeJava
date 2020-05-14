package com.strings;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOccurancesOfaChar {

    public static void main(String[] args) {
        String str = "input";

        Map<Character, Long> characterLongMap = str.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long count = str.chars() // of a specific char
                .filter(ch -> ch == 'e')
                .count();
    }
}

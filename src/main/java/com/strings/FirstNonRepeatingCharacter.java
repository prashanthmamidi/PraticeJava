package com.strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class FirstNonRepeatingCharacter {
    public char firstNonRepeatingCharacterOld(String str) {

        char ch = 'q';
        for (int i = 0; i < str.length(); i++) {
            boolean unique = true;
            for (int j = 0; j < str.length(); j++) {
                if (i != j && str.charAt(i) == str.charAt(j)) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                ch = str.charAt(i);
                break;
            }
        }
        return ch;
    }

    // https://stackoverflow.com/questions/39529831/how-to-find-first-repeated-and-non-repeated-character-in-a-string
    // -using-java8
    public char firstNonRepeatingCharacter(String str) {

        Stream<Character> characterStream = str.chars().mapToObj(i -> (char) i); // stream of characters from string
        // group these characters in map [char, count]
        LinkedHashMap<Character, Long> map = characterStream.collect(groupingBy(
                Function.identity(),
                LinkedHashMap::new, // default is HashMap - we need to preserve the insertion order inorder to find the first element
                Collectors.counting() // count the occurrences
        ));
        // map.forEach((x,y) -> System.out.println("Key: " + x + " Value: " + y));




        Character character = map.entrySet().stream()
                .filter(v -> v.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        return character;
    }

    public char test(String str) {
        IntStream chars = str.chars();
        Stream<Character> characterStream = chars.mapToObj(ch -> (char) ch);
        LinkedHashMap<Character, Long> linkedHashMap =
                characterStream.collect(groupingBy(Function.identity(), LinkedHashMap::new,
                counting()));

        Character character = linkedHashMap.entrySet().stream()
                .filter(map -> map.getValue() == 1)
                .map(map -> map.getKey())
                .findFirst().get();

        return character;
    }
}

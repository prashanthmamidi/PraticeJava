package com.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortAndFilter {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Mathew", "Arnold", 39)
        );

        personList.sort(Comparator.comparing(Person::getLastName));

//        print(personList);

        List<Person> result = personList.stream()
                .filter(person -> person.getLastName().startsWith("C"))
                .collect(Collectors.toList());

        print(result);
    }

    private static void print(List<Person> personList) {
        personList.forEach(person -> System.out.println(person.toString()));
    }
}

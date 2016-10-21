package com.functional.interfaces;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by pupsprashu on 05/03/2016.
 */
public class FuntionalInterfaceTest {
    public static void main(String[] args) {

        Function<String, Integer> stringIntegerFunction = (String str) -> str.length();
        Integer length = convertStringToInteger("Hello", stringIntegerFunction);
        System.out.println("length = " + length);

        Function<Integer, Integer> f2 = (Integer i) -> i * 2;

        Function<String, Integer> f3 = stringIntegerFunction.andThen(f2);
        Integer hello = f3.apply("hello");
        System.out.println("hello = " + hello);

        BiFunction<String, String, Integer> stringComparator = (str, str1) -> (str + str1).length();

        Integer integer = convertStringToInteger("Hello", "world", stringComparator);
        System.out.println("integer = " + integer);

        TriFunction<String, String, String, Integer> triFunction = (String str1, String str2, String str3) -> (str1 + str2 + str3).length();
        Integer apply = triFunction.apply("Hello", "world", "bye");
        System.out.println("apply = " + apply);
    }

    private static Integer convertStringToInteger(String hello, String world, BiFunction<String, String, Integer> biFunction) {
        return biFunction.apply(hello, world);
    }

    private static Integer convertStringToInteger(String input, Function<String, Integer> function) {
        return function.apply(input);
    }
}

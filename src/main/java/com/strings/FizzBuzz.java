package com.strings;

import java.util.stream.IntStream;

public class FizzBuzz
{
    public static void main(String[] args)
    {
        fizzBuzzBeforeJava8(15);
//        fizzBuzzInJava8(15);
    }

    private static void fizzBuzzBeforeJava8(int n)
    {
        for (int i = 1; i <= n; i++)
        {
            if (((i % 5) == 0) && ((i % 3) == 0)) // Is it a multiple of 5 & 3?
                System.out.println("FizzBuzz");
            else if ((i % 5) == 0) // Is it a multiple of 5?
                System.out.println("Buzz");
            else if ((i % 3) == 0) // Is it a multiple of 7?
                System.out.println("Fizz");
            else
                System.out.println(i); // Not a multiple of 5 or 7
        }
    }

    private static void fizzBuzzInJava8(int n) {
        IntStream.rangeClosed(1, n)
                .mapToObj(i -> i % 5 == 0 ? (i % 3 == 0 ? "FizzBuzz" : "Fizz") : (i % 3 == 0 ? "Buzz" : i))
                .forEach(System.out::println);
    }
}

package com.hackerrank;

import java.util.Arrays;

public class ArraySum {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 10, 11};
        int result = Arrays.stream(a).sum();

        System.out.println("result = " + result);

    }
}

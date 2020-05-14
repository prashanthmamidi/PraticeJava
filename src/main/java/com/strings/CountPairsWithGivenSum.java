package com.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 arr = {3, 2, 1, 45, 27, 6, 78, 9, 0};
sum = 9; // given number
So, there will be 2 pairs (3, 6) and (9, 0) whose sum is equal to 9.
 */
public class CountPairsWithGivenSum {
    public static void main(String[] args) {
        Integer[] arr = {3, 2, 1, 45, 27, 6, 78, 9, 0};
        int sum = 9;

        Set<Integer> integerSet = new HashSet<>(Arrays.asList(arr));
        Set<String> uniqueSet = new HashSet<>();
// 9 -3
        for (int x : arr) {
            int y = sum - x;
            if (integerSet.contains(y)) { // y contains in array
                int[] z = new int[] {x, y};
               Arrays.sort(z); // (6,3) -> (3,6)
                uniqueSet.add(Arrays.toString(z));
            }
        }
        uniqueSet.forEach(unique -> System.out.println("unique = " + unique));

        System.out.println("uniqueSet size = " + uniqueSet.size());
    }
}

package com.strings;

import java.util.ArrayList;
import java.util.List;

/*
Given a string, find the number of pairs of substrings of the string that are anagrams of each other.

For example s = mom, the list of all anagrammatic pairs is [m, m], [mo, om] at positions [[0], [2]], [[0, 1], [1, 2]]
 respectively.

1. We need to find all substrings of the given string — create a method for that.
2. We need to be able to check if two strings are anagrams — create a method for that.
3. We need to count all anagrammatic pairs in the given string — create a method for that.
4. Combine everything from above and spit the result — create a method for that.

 */
public class AnagramShelockSubstringpairs {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println("count = " + sherlockAndAnagrams(s));
    }

    static int sherlockAndAnagrams(String s) {
        int count = 0;
        int len = s.length();
        /* Get the substrings for str -> abba
        i -> 1
           j -> 0  --> (0, 1) -> a
           j -> 1  --> (1, 2) -> b
           j -> 2  --> (2, 3) -> b
           j -> 3  --> (3, 4) -> a
        i -> 2
           j -> 0  --> (0, 2) -> ab
           j -> 1  --> (1, 3) -> bb
           j -> 2  --> (2, 4) -> ba
           j -> 3  --> (3, 5) -> cond check - not possible
        i -> 3
           j -> 0  --> (0, 3) -> abb
           j -> 1  --> (1, 4) -> bba
           j -> 2  --> (2, 5) -> cond check - not possible
           j -> 3  --> (3, 6) -> cond check - not possible
         */

        List<String> subList = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i + j <= len) {
                    subList.add(s.substring(j, i + j));
                }
            }
        }
        int subListLen = subList.size();
        for (int x = 0; x < subListLen; x++) {
            for (int y = x + 1; y < subListLen; y++) {
                if (isAnagrams(subList.get(x), subList.get(y))) {
                    //(a,a) (b,b) (ab,ba) (abb, bba)
                    System.out.println("subList.get(x)= " + subList.get(x) + " subList.get(y) = " + subList.get(y));
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isAnagrams(String s1, String s2) {

        int[] firstFreq = new int[26];
        int[] secondFreq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            firstFreq[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            secondFreq[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (firstFreq[i] - secondFreq[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static List<String> subStringPairs(String s) {
        List<String> subStringList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                subStringList.add(s.substring(i, j));
            }

        }
        return subStringList;
    }

}

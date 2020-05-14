package com.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
/*
 We consider two strings to be anagrams of each other if the first string's letters can be rearranged to form the second string.

 */
public class Anagrams {

    public static void main(String[] args) {
        String s1 = "Listen";
        String s2 = "Silent";
        System.out.println(" isAnagram = " + isAnagramUsingLoop(s1.toLowerCase(), s2.toLowerCase()));
        System.out.println(" isAnagram = " + isAnagramUsingSort(s1, s2));
        System.out.println(" isAnagram Using Hashmap = " + isAnagramUsingHashMap(s1, s2));
//        System.out.println(" Make 2 strings Anagram = " + makeAnagram(s1.toLowerCase(), s2.toLowerCase())); // 0 characters to delete
        System.out.println(" Make 2 strings Anagram = " + makeAnagram("bcadeh", "hea")); // 3 characters to delete
        System.out.println(" splitStringAnagram Anagram = " + splitStringAnagram("abccde")); // 3 characters to delete
        System.out.println(" splitStringAnagram Anagram = " + splitStringAnagram("fdhlvosfpafhalll")); // 3 characters to delete
    }

    // find minimum number of characters to be removed to make two strings anagram.
    private static int makeAnagram(String s1, String s2) {

        int[] freqFirst = new int[26];
        int[] freqSecond = new int[26];
        int deletions = 0;

        for(int i = 0; i < s1.length(); i++)
            freqFirst[s1.charAt(i) -'a']++;  //count frequency of each character in first string
        for(int i = 0; i < s2.length(); i++)
            freqSecond[s2.charAt(i) -'a']++; //count frequency of each character in second string

        for(int i = 0; i < 26; i++)
            deletions += Math.abs(freqFirst[i] - freqSecond[i]); //Track the total deletions needed

        return deletions;
    }

    private static int splitStringAnagram1(String s) {
        int len = s.length(), count = 0;
        String s1 = s.substring(0, len/2);
        String s2 = s.substring(len/2, len);

        char[] s1Chars = s1.toCharArray();
        for (char c : s1Chars){
            int index = s2.indexOf(c);
            if (index == -1){
                count++;
            } else {
                s2 = s2.substring(0,index) + s2.substring(index+1);
            }
        }

        return count;

    }


    private static int splitStringAnagram(String s) {
        int len = s.length(), count = 0;
        String s1 = s.substring(0, len/2);
        String s2 = s.substring(len/2, len);

        int[] firstFreq = new int[26];
        int[] secondFreq = new int[26];

        if(s.length()%2 != 0) {
            return -1;
        }

        for(int i =0; i<s1.length();i++) {
            firstFreq[s1.charAt(i) - 'a'] ++;
        }

        for(int i=0; i<s2.length();i++) {
            secondFreq[s2.charAt(i) - 'a'] ++;
        }

        for (int i=0; i<26; i++) {
            if (firstFreq[i] - secondFreq[i] != 0) {
                count++;
            }
        }

        return count/2;
    }

    private static boolean isAnagramUsingLoop(String s1, String s2) {

        int[] firstFreq = new int[26];
        int[] secondFreq = new int[26];

        for(int i =0; i<s1.length();i++) {
            firstFreq[s1.charAt(i) - 'a'] ++;
        }

        for(int i=0; i<s2.length();i++) {
            secondFreq[s2.charAt(i) - 'a'] ++;
        }

        for (int i=0; i<26; i++) {
            if (firstFreq[i] - secondFreq[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAnagramUsingSort(String s1, String s2) { // O(n log n)
        char[] chars1 = s1.toLowerCase().toCharArray();
        char[] chars2 = s2.toLowerCase().toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

    private static boolean isAnagramUsingHashMap(String s1, String s2) {
        char[] chars1 = s1.toLowerCase().toCharArray();
        char[] chars2 = s2.toLowerCase().toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for(char ch : chars1) {
            int count = 1;
            if (map.containsKey(ch)) {
                count = map.get(ch) + 1;
            }
            map.put(ch, count);
        }

        for(char ch:chars2) {
            int count = -1;
            if (map.containsKey(ch)) {
                count = map.get(ch) - 1;
            }
            map.put(ch, count);
        }

        for (char ch : map.keySet()) {
            if (map.get(ch) != 0) {
                return false;
            }
        }
        return true;

    }

}

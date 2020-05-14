package com.strings;
//https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps

/*
Given two strings, determine if they share a common substring. A substring may be as small as one character.

For example, the words "a", "and", "art" share the common substring . The words "be" and "cat" do not share a substring.
 */
public class TwoStringDetermineCommonSubString {

    public static void main(String[] args) {

        String firstWord = "and";
        String secondWord = "grt";

        System.out.println(twoStrings(firstWord, secondWord));
    }

    private static String twoStrings(String s1, String s2) {
        for(char ch : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
            if(s1.indexOf(ch) > -1 && s2.indexOf(ch) > -1)
               return "YES";
        }
        return "NO";
    }
}

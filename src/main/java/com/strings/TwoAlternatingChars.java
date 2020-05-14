package com.strings;
//https://www.hackerrank.com/challenges/two-characters/problem
//https://github.com/RyanFehr/HackerRank/blob/master/Algorithms/Strings/Two%20Characters/Solution.java
public class TwoAlternatingChars {
    /* public static void main(String[] args) {
         String str = "abaacdabd";

         int longestSolution = 0;
         for (int i = 0; i < 26; i++)
         {
             for (int j = i + 1; j < 26; j++)
             {
                 char c1 = (char)((int)'a' + i);
                 char c2 = (char)((int)'a' + j);

                 int currentChar = -1;
                 int countChar = 0;
                 for (int z = 0; z < str.length(); z++)
                 {
                     if (str.charAt(z) == c1)
                     {
                         if (currentChar == 1)
                         {
                             currentChar = -1;
                             break;
                         }
                         currentChar = 1;
                         countChar++;
                     }
                     else if (str.charAt(z) == c2)
                     {
                         if (currentChar == 2)
                         {
                             currentChar = -1;
                             break;
                         }
                         currentChar = 2;
                         countChar++;
                     }
                 }

                 if (currentChar != -1 &&
                         countChar > 1 &&
                         countChar > longestSolution)
                 {
                     longestSolution = countChar;
                 }
             }
         }

         System.out.println(longestSolution);
     }

 }



     */
    /*public static void main(String[] args) {

        String s = "beabeefeab";
        int maxPatternLength = 0;

        if (s.length() == 1)//Edge case where length is 1
        {
            System.out.println(maxPatternLength);
            System.exit(0);
        }

        //Loop through all letter pairs
        for (int i = 0; i < 26; i++) {
            nextLetter:
            for (int j = i + 1; j < 26; j++) {
                char one = (char) ('a' + i); //First char in pair --> a
                char two = (char) ('a' + j); //Second char in pair  --> b
                char lastSeen = '\u0000'; // unicode char for NULL
                int patternLength = 0;

                for (char ch : s.toCharArray()) {  //beabeefeab
                    if (ch == one || ch == two) {
                        if (ch == lastSeen)//Duplicate found
                        {
                            continue nextLetter;
                        }
                        //Not a duplicate
                        patternLength++;
                        lastSeen = ch;
                    }
                }//for char : s

                maxPatternLength = (patternLength > maxPatternLength) ? patternLength : maxPatternLength; //Keep a running max

            }//for j
        }//for i

        System.out.println(maxPatternLength);

    }*/

    public static void main(String[] args) {
        String s = "beabeefeab";
        /*  b,e,a,f - unique chars
        b,e -> afab
        b,a -> ef
        b,f -> eaeeea  // invalid because there are consecutive e's present
        e,f -> babab // looks good
         */

        int maxPatternLength = 0;
        for (int i = 0; i < 26; i++) {  // look from a -> z
            for (int j = i+1; j < 26; j++) { // look from b -> z
                char first = (char) ('a' + i); // a
                char second = (char) ('a' + j); // b
                int matchedCount = 0;
                char next = '\u0000';
                for (char ch : s.toCharArray()) {
                    if ((ch == first) || (ch == second)) {
                        if (next == ch) {
                            break;
                        }
                        matchedCount++;
                        next = ch;
                    }
                }
                maxPatternLength = Math.max(maxPatternLength, matchedCount); //Keep a running max
            }
        }

        System.out.println("maxPatternLength = " + maxPatternLength);

    }
}
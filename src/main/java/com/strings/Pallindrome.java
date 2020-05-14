package com.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Pallindrome {

    public static Boolean isPalindrome(String s) {

        String str =
                s.replace(" ", "")
                        .replace(",", "")
                        .replace("!", "")
                        .replace("-", "")
                        .toLowerCase();
        int len = str.length();

        for (int i = 0; i < len/2; i++) {
            char firstChar = str.charAt(i);
            char lastChar = str.charAt(len-1-i);

            if (firstChar != lastChar) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("args[2] = " + args[2]);
        List list = new ArrayList();
        list.add("f");
        list.add(2);
        System.out.println(list.get(0) instanceof Object);
        System.out.println(list.get(1) instanceof Integer);


        for (int i=0; i<10; i=i++) {
            i+=1;
            System.out.println("He");
        }
        System.out.println("apple".compareTo("banan"));
   /* System.out.println(isPalindrome("dollop"));                     // false
    System.out.println(isPalindrome("level"));                      // true
    System.out.println(isPalindrome("Ana"));                        // true
    System.out.println(isPalindrome("1010"));      */                   //false
        System.out.println(isPalindrome(""));                         //true
   /* System.out.println(isPalindrome("101"));                         //true
    System.out.println(isPalindrome("110"));                         //false
    System.out.println(isPalindrome("10101"));                         //true
    System.out.println(isPalindrome("A car, a man, a maraca!"));    // true
    System.out.println(isPalindrome("A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal - Panama!")); //true */
    }

    public static String findNumber(List<Integer> arr, int k) {
        // Write your code here
        if (arr.contains(k))
            return "YES";
         return "NO";
    }

    public static List<Integer> oddNumbers(int l, int r) {
        // Write your code here
        System.out.println("apple".compareTo("banan"));
        List<Integer> list = new ArrayList<>();
        for (int i = l; i < r; i++) {
            if (i % 2 != 0) {
                list.add(i);
            }
        }

        return list;

    }

}

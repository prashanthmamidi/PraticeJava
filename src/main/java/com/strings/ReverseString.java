package com.strings;

public class ReverseString {

    public static void main(String[] args) {
        ReverseString obj = new ReverseString();
        obj.reverse();
        obj.reverseWithOutLibFun();
    }

    private void reverseWithOutLibFun() {
        String str = "hellotest";
        StringBuilder sb = new StringBuilder();

        for(int i = str.length() - 1; i > 0; i--) {
            sb.append(str.charAt(i));
        }
        System.out.println("sb.reverseWithOutLibFun(hellotest) = " + sb.toString());
    }

    private void reverse() {
        StringBuilder sb = new StringBuilder("hellotest");
        System.out.println("sb.reverse(hellotest) = " + sb.reverse());
    }


    public static String ReverseWords(String input) {
        String[] words = input.split(" ");
        String returnWords = "";

        for (int i = 0; i < words.length;i++)
        {
            String thisWord = "";
            String word = words[i];
            for (int j = 0;j < word.length();j++)
                thisWord = Character.isLetter(word.charAt(j)) ? word.charAt(j) + thisWord : thisWord + word.charAt(j);
            returnWords += thisWord + " ";
        }
        return returnWords;
    }




}

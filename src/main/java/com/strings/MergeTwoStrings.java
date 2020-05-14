package com.strings;

public class MergeTwoStrings {
    public static void main(String[] args) {
        MergeTwoStrings obj = new MergeTwoStrings();

        String result = obj.merge("abcghgygy", "defj");

        System.out.println("result  = " + result);// adbecf

    }

    private String merge(String str1, String str2) {
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        for (; i < str1.length() && i < str2.length(); i++) {
            sb.append(str1.charAt(i)).append(str2.charAt(i));
        }
        for(; i < str1.length(); i++) {
            sb.append(str1.charAt(i));
        }
        for(; i < str2.length(); i++) {
            sb.append(str2.charAt(i));
        }
        return sb.toString();
    }
}

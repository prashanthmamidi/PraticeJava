package com.test.TDD;

/**
 * Created by mami01 on 16/05/14.
 */
public class PalindromeChecker {
    public boolean isValidPalindrome(String obj) {
        StringBuffer stringBuffer = new StringBuffer(obj);
        String reverseObj = stringBuffer.reverse().toString();
        if (obj.equals(reverseObj)) return true;
        return false;
    }
}

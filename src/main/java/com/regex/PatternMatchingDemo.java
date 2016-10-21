package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pupsprashu on 03/02/2016.
 */
public class PatternMatchingDemo {
    public static void main(String[] args) {
        // String to be scanned to find the pattern.
        String line = "This order was placed for QT456! OK?";
        //String regex = "(.*)(\\d+)(.*)";
       // String regex = "(\\d+)"; // Matches 1 or more of the digits
        String regex = "(.*)(\\d+)(.*)"; // Matches 0 or more occurrences of preceding expression

        Pattern pattern = Pattern.compile(regex);

        //A Matcher object is the engine that interprets the pattern and performs match operations against an input string.
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            System.out.println("Found value: " + matcher.group(0) );
            System.out.println("Found value 1: " + matcher.group(1) );
            System.out.println("Found value: " + matcher.group(2) );
        } else {
            System.out.println("NO MATCH");
        }

    }
}

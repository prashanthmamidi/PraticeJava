package com.strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


/*
1990-12-22
12345

12345-901222

 */

/*
value1 = Wed Jan 31 00:00:00 UTC 2001
number = 9

value1 = Mon Mar 01 00:00:00 UTC 1982
number = 1234567890
 */

class Result {
    public static String formatAsCustomString(Date date, int number) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
        String dt = simpleDateFormat.format(date);
        String num = String.valueOf(number);
        return leftPad(num, 5,'0') + "-" + dt;
    }

    public static String leftPad(String originalString, int length,char padCharacter) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + originalString.length() < originalString.length()) {
            sb.append(padCharacter);
        }
        sb.append(originalString);
        String paddedString = sb.toString();
        return paddedString;
    }
}

public class FormatAsCustomString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String sDate = bufferedReader.readLine();
        try
        {
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date date = simpleDateFormat.parse(sDate);
            int number = Integer.parseInt(bufferedReader.readLine().trim());
            String result = Result.formatAsCustomString(date, number);
            bufferedWriter.write(result);
        }catch (ParseException e)
        {
            System.out.println(e);
        }
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

package com.strings;

// https://www.geeksforgeeks.org/how-to-design-a-tiny-url-or-url-shortener/
//https://stackoverflow.com/questions/742013/how-do-i-create-a-url-shortener

/*
How to convert the ID to a shortened URL

1. Think of an alphabet we want to use. In your case, that's [a-zA-Z0-9]. It contains 62 letters.
shorturl = []
while num > 0
  remainder = modulo(num, 62)
  shorturl.push(remainder)
  num = divide(num, 62)

digits = digits.reverse
 */
public class TinyURL {
    public static void main(String[] args) {
        // From the Long URL - get the corresponding Integer Id from the DB
        int num = 12345;

        String shortUrl = shortUrlFrom(num);

        System.out.println("shortUrl = http://shor.ty/" + shortUrl);

        int integerId = getIdFrom(shortUrl);

        System.out.println("integerId = " + integerId);
    }

    private static String shortUrlFrom(int num) {  // So the task is to convert a decimal number to base 62 number.
        char[] digits = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray(); // 62 possible characters

        StringBuilder shorturl = new StringBuilder();

        while (num > 0) {
            shorturl.append(digits[num % 62]);   // store the actual character in shortUrl
            num = num/62;
        }
        // Reverse shortURL to complete base conversion
        return shorturl.reverse().toString();
    }

    private static int getIdFrom(String shortUrl) {
        int id = 0;
        // A simple base conversion logic
        for(int i = 0; i < shortUrl.length(); i++) {
            char ch = shortUrl.charAt(i);
            if ('a' <= ch && ch <= 'z') {
                id = id * 62 + ch - 'a';
            }
            if ('A' <= ch && ch <= 'Z') {
                id = id * 62 + ch - 'A' + 26;
            }
            if ('0' <=ch && ch <= '9') {
                id = id * 62 + ch - '0' + 52;
            }
        }
        return id;
    }

}

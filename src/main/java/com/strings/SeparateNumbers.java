package com.strings;

public class SeparateNumbers {

    public static void main(String[] args) {
        SeparateNumbers.split("99100");
    }

    public static void split(String str)
    {
        int len = str.length();

        // if there is only 1 number
        // in the string then
        // it is not possible to split it
        if (len == 1) {
            System.out.println("Not Possible");
            return;
        }

        String s1 = "", s2 = "";
        long num1, num2;

        for (int i = 0; i <= len / 2; i++) {

            int flag = 0;

            // storing the substring from
            // 0 to i+1 to form initial
            // number of the increasing sequence
            s1 = str.substring(0, i + 1);
            num1 = Long.parseLong((s1));
            num2 = num1 + 1;

            // convert string to integer
            // and add 1 and again convert
            // back to string s2
            s2 = Long.toString(num2);
            int k = i + 1;
            while (flag == 0) {
                int l = s2.length();

                // if s2 is not a substring
                // of number than not possile
                if (k + l > len) {
                    flag = 1;
                    break;
                }

                // if s2 is the next substring
                // of the numeric string
                if ((str.substring(k, k + l).equals(s2))) {
                    flag = 0;

                    // Incearse num2 by 1 i.e the
                    // next number to be looked for
                    num2++;
                    k = k + l;

                    // check if string is fully
                    // traversed then break
                    if (k == len)
                        break;
                    s2 = Long.toString(num2);
                    l = s2.length();
                    if (k + 1 > len) {

                        // If next string doesnot occurs
                        // in a given numeric string
                        // then it is not possible
                        flag = 1;
                        break;
                    }
                }

                else
                    flag = 1;
            }

            // if the string was fully traversed
            // and conditions were satisfied
            if (flag == 0) {
                System.out.println("Possible"
                        + " " + s1);
                break;
            }

            // if conditions failed to hold
            else if (flag == 1 && i > len / 2 - 1) {
                System.out.println("Not Possible");
                break;
            }
        }
    }

}

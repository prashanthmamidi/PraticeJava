package com.strings;

public class checkSum {

    static boolean checkLuhn(String idNumber)
    {
        boolean flag = false;
        int totalDigits = idNumber.length();
        int checkSumValue = 0;
        for (int i = totalDigits - 1; i >= 0; i--) {
            int digit = idNumber.charAt(i) - '0';

            if (flag) {
                digit = digit * 2;
            }
            checkSumValue = checkSumValue + digit / 10;
            checkSumValue = checkSumValue + digit % 10;

            flag = !flag;
        }
        return (checkSumValue % 10 == 0);
    }

    // Driver code
    static public void main (String[] args)
    {
        String cardNo = "79927398713";
        if (checkLuhn(cardNo))
            System.out.println("This is a valid card");
        else
            System.out.println("This is not a valid card");

    }
}

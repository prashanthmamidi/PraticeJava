package com.strings;

public class Calculator {
    public static String ErrorMessage = "";
    public static void main(String[] args) {
        Calc("1","0","Divide");
        System.out.println("ErrorMessage = " + ErrorMessage);
    }

    public static Double Calc(String value1, String value2, String calcOperator) {

        System.out.println("value1 = " + value1);
        System.out.println("value2 = " + value2);
        System.out.println("calcOperator = " + calcOperator);

        Double v1 = new Double(0);
        Double v2 = new Double(0);
        try {
            v1 = new Double(value1);
            v2 = new Double(value2);
        }
        catch (NumberFormatException e) {
            ErrorMessage = "VALUES MUST BE NUMERIC";
        }
        Double returnValue = new Double(0);

        try {

            switch (calcOperator) {
                case "Add":
                    returnValue = v1 + v2;
                    break;
                case "Subtract":
                    returnValue = v1 - v2;
                    break;
                case "Multiply":
                    returnValue = v1 * v2;
                    break;
                case "Divide":
                    try {
                        returnValue = v1 / v2;
                    } catch(ArithmeticException ex) {
                        ErrorMessage = "ARITHMETIC ERROR";
                    }
                    break;
                default:
                    ErrorMessage = "INCORRECT OPERATOR";
            }
        } catch(Exception ex) {
            ErrorMessage = "ARITHMETIC ERROR";
        }
        if (returnValue.toString().contains("Infinity")) {
            ErrorMessage = "ARITHMETIC ERROR";
        }
        return returnValue;
    }
}

package com.functional.interfaces;

public class InterfaceVsLambda {

    public InterfaceVsLambda(Operation operation) {
        System.out.println("additionFunc = " + operation.addition(10,20));
    }

    public static void main(String[] args) {
        Operation additionFunc = (int a, int b) -> a + b;
        InterfaceVsLambda obj = new InterfaceVsLambda(additionFunc);

    }
}

interface Operation {
    int addition(int a, int b);
}

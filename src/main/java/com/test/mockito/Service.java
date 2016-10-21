package com.test.mockito;

/**
 * Created by pupsprashu on 28/02/2016.
 */
public class Service {

    public String someMethod() {
        System.out.println("Do Nothing");
        return "hello";
    }

    public String someMethod(String s) {
        return s;
    }
}

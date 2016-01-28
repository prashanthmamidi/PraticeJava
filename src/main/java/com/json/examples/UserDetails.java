package com.json.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mami01 on 14/05/14.
 */
public class UserDetails {

    private int age = 31;
    private String name = "legend";
    private List<?> messages = new ArrayList<Object>() {
        {
            add("msg1");
            add("msg2");
            add("msg3");
        }
    };

    public String toString() {
        return "UserDetails [age=" + age + ", name=" + name + ", " +
                "messages=" + messages + "]";
    }

}

package com.collections;

import java.util.HashMap;

/**
 * Created by mami01 on 20/03/14.
 * http://www.programcreek.com/2011/07/java-equals-and-hashcode-contract/
 * Common mistake is shown in the example below
 */
public class Apple {

    private String color;

    public Apple(String color) {
        this.color = color;
    }

    public int hashCode(){
        return this.color.length();
    }
    public boolean equals(Object obj) {
        if (!(obj instanceof Apple))
            return false;
        if (obj == this)
            return true;
        return this.color.equals(((Apple) obj).color);
    }

    public static void main(String[] args) {
        Apple a1 = new Apple("green");
        Apple a2 = new Apple("red");

        //hashMap stores apple type and its quantity
        HashMap<Apple, Integer> m = new HashMap<Apple, Integer>();
        m.put(a1, 10);
        m.put(a2, 20);
        System.out.println(m.get(a1));
        System.out.println(m.get(new Apple("green"))); // returns if we don't override Hashcode
    }

}
/*
In this example, a green apple object is stored successfully in a hashMap,
but when the map is asked to retrieve this object, the apple object is not found.The program above prints null.
However, we can be sure that the object is stored in the hashMap by inspecting in the debugger:
 */

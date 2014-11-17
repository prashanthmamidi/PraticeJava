package com.collections;

import java.util.Set;
import java.util.TreeMap;

/**
 * Created by mami01 on 20/03/14.
 */
public class TestTreeMap {

    public static void main(String[] args) {

        Dog d1 = new Dog("red");
        Dog d2 = new Dog("black");
        Dog d3 = new Dog("white");
        Dog d4 = new Dog("white");

        TreeMap treeMap = new TreeMap();
        treeMap.put(d1, 10);
        treeMap.put(d2, 15);
        treeMap.put(d3, 5);
        treeMap.put(d4, 20);

        Set<Dog> set = treeMap.keySet();
        for (Dog dog : set) {
            System.out.println(dog + " - " + treeMap.get(dog) );
        }
     /*   for (Entry entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }*/
    }
}

package com.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by mami01 on 20/03/14.
 */
public class TestHashMap {

    public static void main(String[] args) {

        Dog d1 = new Dog("red");
        Dog d2 = new Dog("black");
        Dog d3 = new Dog("white");
        Dog d4 = new Dog("white");
        Map<Dog, Integer> hashMap = new HashMap<Dog, Integer>();
        hashMap.put(d1, 10);
        hashMap.put(d2, 15);
        hashMap.put(d3, 5);
        hashMap.put(d4, 20);

        //print size
        System.out.println(hashMap.size());

        //loop HashMap
   /*     for (Object entry : hashMap.entrySet()) {
            System.out.println(entry.getKey().toString() + " - " + entry.getValue());
        }*/
        Set<Dog> set = hashMap.keySet();
        for (Object dog : set) {
            System.out.println(dog.toString() + "- " + hashMap.get(dog));
        }

        Object a[] = new String[10];

    }
}

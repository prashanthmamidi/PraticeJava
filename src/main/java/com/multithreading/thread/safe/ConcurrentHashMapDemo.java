package com.multithreading.thread.safe;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        Map<Integer, String> map = new ConcurrentHashMap();
      //  Map<Integer, String> map = new HashMap<>();

        map.put(1, "Hello");
        map.put(2, "Hello2");
        map.put(3, "Hello3");
        map.forEach(
            (key, value) -> {
           //     map.put(4, "Hello5"); // We get ConcurrentModificationException when we add new element to the collection
             //   map.put(3, "I am modified"); // if we update/remove the existing records, we don't get ConcurrentModificationException
                map.putIfAbsent(6, "test");
                System.out.println(key + "," + value);
            }
        );
    }
}

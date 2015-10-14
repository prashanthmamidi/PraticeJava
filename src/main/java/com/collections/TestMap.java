package com.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("hello", 5);
        map.put("hello1", 5);
        map.computeIfAbsent("hello2", (v) -> 10);

        map.merge("hello", 5, (k,v) -> 20);


        map.forEach((k, v) -> System.out.println(k + "," + v));
    }
}

package com.multithreading.thread.safe;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by mami01 on 07/03/14.
 */
public class ThreadSafeIteratorExample {

    public static void main(String[] args) {
        List<String> myList = new CopyOnWriteArrayList<String>();
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");

        Iterator<String> itr = myList.iterator();
        while(itr.hasNext()) {
            String value = itr.next();
            System.out.println("List Value:"+value);
            if (value.equals("3")) {
                myList.remove("4");
                myList.add("6");
                myList.add("3");
            }
        }
        System.out.println("List Size:"+myList.size());

        Map<String,String> myMap = new ConcurrentHashMap<String, String>();
        myMap.put("1", "1");
        myMap.put("2", "2");
        myMap.put("3", "3");

        Iterator<String> itr1 = myMap.keySet().iterator();
        while (itr1.hasNext()) {
            String key = itr1.next();
            System.out.println("Map value: " + myMap.get(key));
            if (key.equals("1")) {
                myMap.remove("3");
                myMap.put("4", "4");
                myMap.put("5", "5");
            }
        }
        System.out.println("Map Size:"+myMap.size());
    }

}
/*
From the above example its clear that:

1. concurrent Collection classes can be modified avoiding ConcurrentModificationException

2. In case of CopyOnWriteArrayList, iterator doesn’t accommodate the changes in the list and works on the original list.

3. In case of ConcurrentHashMap, the behavior is not always the same.
 */

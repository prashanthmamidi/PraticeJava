package com.multithreading.thread.safe;

import java.util.*;

/**
 * Created by mami01 on 07/03/14.
 * http://www.journaldev.com/378/how-to-avoid-concurrentmodificationexception-when-using-an-iterator
 *
 */
public class IteratorExample {

    public static void main(String[] args) {
        List<String> myList = new ArrayList<String>();

        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");

        Iterator<String> it = myList.iterator();
        while(it.hasNext()){
            String value = it.next();
            System.out.println("List Value:"+value);
            if(value.equals("3"))
               myList.remove(value);  // // if we update/remove the existing records, we don't get ConcurrentModificationException
        }

        Map<String,String> myMap = new HashMap<String,String>();
        myMap.put("1", "1");
        myMap.put("2", "2");
        myMap.put("3", "3");

        Iterator<String> it1 = myMap.keySet().iterator();
        while(it1.hasNext()){
            String key = it1.next();
            System.out.println("Map Value:"+myMap.get(key));
            if(key.equals("2")){
                myMap.put("4", "4"); // We get ConcurrentModificationException when we have change the collection, here we are adding new element
                //myMap.put("1","4"); // if we update/remove the existing records, we don't get ConcurrentModificationException
            }
        }

    }
}


/*
To Avoid ConcurrentModificationException in multi-threaded environment:

        1. You can convert the list to an array and then iterate on the array. This approach works well for small or medium size list but if the list is large then it will affect the performance a lot.

        2. You can lock the list while iterating by putting it in a synchronized block. This approach is not recommended because it will cease the benefits of multithreading.

        3. If you are using JDK1.5 or higher then you can use ConcurrentHashMap and CopyOnWriteArrayList classes. It is the recommended approach.
        */

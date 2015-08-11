package com.multithreading.thread.safe;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList();
        //List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.stream()
            .forEach(element -> {
                list.add(4);
                System.out.println(element); // iterator doesn’t accommodate the changes in the list and works on the original list.
            });
    }
}

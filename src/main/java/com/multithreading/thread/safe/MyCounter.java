package com.multithreading.thread.safe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mami01 on 28/02/14.
 * http://www.programcreek.com/2014/02/how-to-make-a-method-thread-safe-in-java/
 *
 */
public class MyCounter {
    private static int count  = 0;
    private static AtomicInteger counter = new AtomicInteger(0);

    private static int getCount() {
        return count++;
    }

    //Make a method thread-safe - – Method 1
    private static synchronized int getCountUsingSynchronized() {
        return count++;
    }

    //Make a method thread-safe - – Method 2
    private static int getCountUsingAtomic() {
        return counter.getAndIncrement();
    }

    public static void main(String[] args) {
        MyCounter myCounter = new MyCounter();
        System.out.println(myCounter.getCount());
        System.out.println(myCounter.getCountUsingSynchronized());
        System.out.println(myCounter.getCountUsingAtomic());


    }
}

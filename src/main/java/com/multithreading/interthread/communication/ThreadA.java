package com.multithreading.interthread.communication;

/**
 * Created by mami01 on 27/02/14.
 *
 * http://www.programcreek.com/2009/02/notify-and-wait-example/
 *
 *
 1. synchronized keyword is used for exclusive accessing.
 2. To make a method synchronized, simply add the synchronized keyword to its declaration.
     Then no two invocations of synchronized methods on the same object can interleave with each other.
 3. Synchronized statements must specify the object that provides the intrinsic lock.
    When synchronized(this) is used, you have to avoid to synchronizing invocations of other objects’ methods.
 4. wait() tells the calling thread to give up the monitor and go to sleep until some other thread enters the same monitor and calls notify( ).
 5. notify() wakes up the first thread that called wait() on the same object.

 */
public class ThreadA {
    public static void main(String[] args){
        ThreadB b = new ThreadB();
        b.start();
        System.out.println("ThreadB has started ...");

        synchronized(b){
            try{
                System.out.println("Waiting for b to complete...");
              //  b.wait();
                System.out.println("Waiting for b is complete...");
            }catch(Exception e){
                e.printStackTrace();
            }

            System.out.println("Total is: " + b.total);
        }
    }
}

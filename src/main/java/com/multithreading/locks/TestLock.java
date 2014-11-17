package com.multithreading.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.util.concurrent.locks.ReentrantReadWriteLock.*;

/**
 * Created by pupsPrashuVishnu on 01/03/14.
 * http://tutorials.jenkov.com/java-concurrency/locks.html
 *
 * If a thread already holds the lock on a monitor object, it has access to all blocks synchronized on the same monitor object.
 * This is called reentrance. The thread can reenter any block of code for which it already holds the lock.
 */
public class TestLock {

    protected Lock lock = new ReentrantLock();
    public void outer() throws InterruptedException {
        System.out.println(" Got DATA from DB ...." + Thread.currentThread().getName());
        lock.lock();
       try{
        Thread.sleep(5000);
        System.out.println(" In Outer ...." + Thread.currentThread().getName());
        inner();
        System.out.println(" After Inner ...." + Thread.currentThread().getName());
        }
        finally {
          lock.unlock();
        }
    }

    public void inner () {
        System.out.println(" Got DATA from INNER DB ...." + Thread.currentThread().getName());
        lock.lock();
        System.out.println(" In Inner ...." + Thread.currentThread().getName());
        lock.unlock();
    }

    public static void main(String[] args) {
        final TestLock testLock = new TestLock();

        new Thread("T1") {
            public void run() {
                System.out.println(" In T1 ....");
                try {
                    testLock.outer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread("T2") {
            public void run() {
                System.out.println(" In T2 ....");
                try {
                    testLock.outer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

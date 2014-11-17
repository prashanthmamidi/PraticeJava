package com.multithreading.concurrent.locks;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by mami01 on 28/02/14.
 */
public class TestLock {
    Lock lock = new ReentrantLock();
    public void testLock() throws InterruptedException {
        lock.lockInterruptibly(); //Acquires the lock unless the current thread is interrupted.

        //xxxx
        lock.unlock();
    }

    public void testTryLock() {
        boolean isLockAvailable = lock.tryLock(); //Acquires the lock only if it is free at the time of invocation.
        if (isLockAvailable) {
            try {
                // manipulate protected state
            } finally {
                if (isLockAvailable)
                    lock.unlock();
            }
        } else {
            // perform alternative actions
        }
    }
    public static void main(String[] args) {
        TestLock tl = new TestLock();
        try {
            String[] var = {"A","B","C"};
            System.out.println(var.toString());
            System.out.println(Arrays.toString(var));
            tl.testLock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

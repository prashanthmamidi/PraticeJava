package com.multithreading.deadlock;

/**SEE NOTE BELOW
 * Created by mami01 on 07/03/14.
 * http://www.journaldev.com/1058/java-deadlock-example-and-how-to-analyze-deadlock-situation
 *
 * Deadlock is a programming situation where two or more threads are blocked forever,
 * this situation arises with at least two threads and two or more resources.
 */
public class ThreadDeadlock {
    public static void main(String[] args) throws InterruptedException {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        Thread t1 = new Thread(new SyncThread(obj1, obj2), "T1");
        Thread t2 = new Thread(new SyncThread(obj2, obj3), "T2");
        Thread t3 = new Thread(new SyncThread(obj3, obj1), "T3");

        t1.start();
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(1000);
        t3.start();

        t1.join(6000);
        t2.join(6000);
        t3.join(6000);
    }
}

class SyncThread implements Runnable {
    private Object obj1;
    private Object obj2;

    public SyncThread(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " acquiring lock on " + obj1);
        synchronized (obj1) {
            System.out.println(name + " acquired lock on "+obj1);
            work();
            System.out.println(name + " acquiring lock on "+obj2);
            synchronized (obj2) {
                System.out.println(name + " acquired lock on "+obj2);
                work();
            }
            System.out.println(name + " released lock on "+obj2);
        }
        System.out.println(name + " released lock on "+obj1);
        System.out.println(name + " finished execution.");
    }
    private void work() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
In above program SyncThread is implementing Runnable interface and
it works on two Objects by acquiring lock on each one of them one by one using synchronized block.
 */

/*
****************************************Analyze Deadlock******************************************
*
1. To analyze a deadlock, we need to look at the java thread dump of the application
2. we need to look out for the threads with state as BLOCKED
3. then the resources it’s waiting to lock, every resource has a unique ID using which we can find which thread is already holding the lock on the object.
4. To fix, we need to make code changes to avoid deadlock situation.
 */

/*
****************************************Avoid Deadlock******************************************
* These are some of the guidelines using which we can avoid most of the deadlock situations.
1. Avoid Nested Locks - avoid locking another resource if you already hold one.
2. Lock Only What is Required  - You should acquire lock only on the resources you have to work on, for example in above program I am locking the complete Object resource but if we are only interested in one of it’s fields, then we should lock only that specific field not complete object.
3. Avoid waiting indefinitely - You can get deadlock if two threads are waiting for each other to finish indefinitely using thread join. If your thread has to wait for another thread to finish, it’s always best to use join with maximum time you want to wait for thread to finish.

 */
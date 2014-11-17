package com.concurrent.api;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by mami01 on 25/04/14.
 *
 * Allows multiple threads to wait for each other (barrier) before proceeding.
 * All threads which wait for each other to reach barrier are called parties,
 * CyclicBarrier is initialized with number of parties to be wait and threads wait for each other by calling CyclicBarrier.await() method which is a blocking method in Java
 * and  blocks until all Thread or parties call await().

 *you can not reuse CountDownLatch once count reaches zero while you can reuse CyclicBarrier by calling reset() method which resets Barrier to its initial State
 * http://javarevisited.blogspot.sg/2012/07/cyclicbarrier-example-java-5-concurrency-tutorial.html
 */
public class CyclicBarrierExample {

    private static class Task implements Runnable {

        private CyclicBarrier barrier;

        public Task(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
            }catch (InterruptedException ex) {
                System.out.println(CyclicBarrierExample.class.getName() + ex);
            } catch (BrokenBarrierException ex) {
                System.out.println(CyclicBarrierExample.class.getName() + ex);
            }
        }
    }


    public static void main(String[] args) {
        //creating CyclicBarrier with 3 parties i.e. 3 Threads needs to call await()

        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                //This task will be executed once all thread reaches barrier
                System.out.println("All parties are arrived at barrier, lets play");
            }
        });

        Thread t1 = new Thread(new Task(cyclicBarrier), "Thread 1");
        Thread t2 = new Thread(new Task(cyclicBarrier), "Thread 2");
        Thread t3 = new Thread(new Task(cyclicBarrier), "Thread 3");

        t1.start(); t2.start();t3.start();

    }


}

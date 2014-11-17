package com.concurrent.api;

import java.util.concurrent.CountDownLatch;

/**
 * Created by mami01 on 25/04/14.
 *
 * http://javarevisited.blogspot.co.uk/2012/07/countdownlatch-example-in-java.html
 * A synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes.
 *
 * Any thread, usually main thread of application,  which calls CountDownLatch.await() will wait until count reaches zero or its interrupted by another Thread.
 * All other thread are required to do count down by calling CountDownLatch.countDown() once they are completed or ready to the job. as soon as count reaches zero, Thread awaiting starts running.
 *
 * One of the disadvantage of CountDownLatch is that its not reusable once count reaches to zero you can not use CountDownLatch any more,
 * but don't worry Java concurrency API has another concurrent utility called CyclicBarrier for such requirements.
 *
 *
 * Read more: http://javarevisited.blogspot.com/2012/07/countdownlatch-example-in-java.html#ixzz2zticXzYF
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(3);    //count is 3 since we have 3 Threads (Services)
        Thread cacheService = new Thread(new Service("CacheService", 1000, latch));
        Thread alertService = new Thread(new Service("AlertService", 1000, latch));
        Thread validationService = new Thread(new Service("ValidationService", 1000, latch));

        cacheService.start();
        alertService.start();
        validationService.start();
/*        application should not start processing any thread until all service is up and ready to do there job.
         Countdown latch is idle choice here, main thread will start with count 3 and wait until count reaches zero.
         each thread once up and read will do a count down. this will ensure that main thread is not started processing until all services is up.*/

        try {
            latch.await(); //main thread is waiting on CountDownLatch to finish
            System.out.println("All services are up, Application is starting now");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }}

/**
 * Service class which will be executed by Thread using CountDownLatch synchronizer.
 */
class Service implements Runnable {

    private final String name;
    private final int timeToStart;
    private final CountDownLatch countDownLatch;

    Service(String name, int timeToStart, CountDownLatch countDownLatch) {
        this.name = name;
        this.timeToStart = timeToStart;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(timeToStart);
        } catch (InterruptedException ex) {
            System.out.println(Service.class.getName() + ex);
        }
        System.out.println(name + "is up");
        countDownLatch.countDown();//reduce count of CountDownLatch by 1

    }
}

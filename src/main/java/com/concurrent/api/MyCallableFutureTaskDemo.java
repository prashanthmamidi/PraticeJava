package com.concurrent.api;

import java.util.concurrent.*;

/**
 * Created by mami01 on 06/03/14.
 */
public class MyCallableFutureTaskDemo implements Callable<String> {
    private long waitTime;
    public MyCallableFutureTaskDemo(long waitTime) {
        this.waitTime = waitTime;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(waitTime);
        //return the thread name executing this callable task
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) {
        Callable<String> callable1 = new MyCallableFutureTaskDemo(5000);
        Callable<String> callable2 = new MyCallableFutureTaskDemo(7000);

        FutureTask<String> futureTask1 = new FutureTask<String>(callable1);
        FutureTask<String> futureTask2 = new FutureTask<String>(callable2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(futureTask1);
        executorService.execute(futureTask2);

        while (true) {
            try {
                if (futureTask1.isDone() && futureTask2.isDone()) {
                    System.out.println("Both the Future tasks are Done");
                    System.out.println("Future Task1 output = " + futureTask1.get());
                    System.out.println("Future Task2 output = " + futureTask2.get());
                    executorService.shutdown();
                    return;
                }
                if (!futureTask1.isDone())
                    System.out.println("Future Task1 output = " + futureTask1.get());
                if (!futureTask2.isDone())
                    System.out.println("Future Task2 output = " + futureTask2.get());
/*                System.out.println("Waiting for FutureTask2 to complete...");
                String s = futureTask2.get(50000L, TimeUnit.MILLISECONDS);
                if (s != null)
                    System.out.println("FutureTask2 output = " + s);
                else System.out.println("ELSE FutureTask2 output = " + futureTask2.get() );*/


            } catch (InterruptedException ex) {}
            catch (ExecutionException e) {
                e.printStackTrace();
            } /*catch (TimeoutException e) {
                // do nothing
            }*/
        }



    }
}

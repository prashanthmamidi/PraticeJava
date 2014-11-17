package com.concurrent.api.threadpoolexecutor;

import java.util.concurrent.*;

/**
 * Created by mami01 on 12/03/14.
 */
public class FutureTaskDemo extends FutureTask<String> {

    public FutureTaskDemo(Callable<String> callable) {
        super(callable);
    }

    public void testReRun() {
        System.out.println(" Before Runing re-run ...");
        super.runAndReset();
        System.out.println(" After Runing re-run ...");
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTaskDemo futureTaskDemo = new FutureTaskDemo(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return Thread.currentThread().getName();
            }
        });

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(futureTaskDemo);

        System.out.println("Getting task ..." + futureTaskDemo.get());
        executorService.submit(futureTaskDemo);
        System.out.println("Getting task should error ..." + futureTaskDemo.get());
        futureTaskDemo.testReRun();
        System.out.println("Getting task after rerun ..." + futureTaskDemo.get());
    }
}

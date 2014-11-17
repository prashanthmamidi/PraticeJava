package com.concurrent.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by mami01 on 06/03/14.
 * http://www.journaldev.com/1090/java-callable-future-example
 */
public class MyCallableFutureDemo implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) {
        // Get ExecutorService from Executors utility class, thread pool size i
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //create a list to hold the Future object associated with Callable
        List<Future<String>> futList = new ArrayList<Future<String>>();
        //Create MyCallable instance
        Callable<String> callable = new MyCallableFutureDemo();
        for (int i=0; i<100; i++) {
            //submit Callable tasks to be executed by thread pool
            Future<String> future = executorService.submit(callable);
            //add Future to the list, we can get return value using Future
            futList.add(future);
        }
        for (Future<String> fut : futList) {
            try {
                //print the return value of Future, notice the output delay in console
                // because Future.get() waits for task to get completed
                System.out.println(new Date() + "::" + fut.get());
            } catch (InterruptedException ex){}
            catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
Tip: What if we want to override some of the methods of Future interface,
for example overriding get() method to timeout after some default time rather than waiting indefinitely,
 in this case FutureTask class comes handy that is the base implementation of Future interface.
 */
















package com.concurrent.api.threadpoolexecutor;

import com.concurrent.api.WorkerThread;

import java.util.concurrent.*;

/**
 * Created by pupsPrashuVishnu on 03/03/14.
 */
public class WorkerPool {

    public static void main(String args[]) throws InterruptedException{
        //RejectedExecutionHandler implementation
        RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();
        //Get the ThreadFactory implementation to use
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        //creating the ThreadPoolExecutor
        // Keep-alive times -- If the pool currently has more than corePoolSize threads, excess threads will be terminated if they have been idle for more than the keepAliveTime (see getKeepAliveTime(java.util.concurrent.TimeUnit)).
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(0, 5, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), threadFactory, rejectionHandler);
//        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(1, 3, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), threadFactory, rejectionHandler);
        //start the monitoring thread
        MyMonitorThread monitor = new MyMonitorThread(executorPool, 3);
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();
        //submit work to the thread pool
        for(int i=0; i<12; i++){
            executorPool.execute(new WorkerThread("cmd"+i));
        }

        Thread.sleep(5000);
        //shut down the pool
        executorPool.shutdown();
        //shut down the monitor thread
        Thread.sleep(3000);
        monitor.shutdown();

    }
}




package com.concurrent.api.blocking.queue;

import com.multithreading.interthread.communication.ThreadA;

import java.util.concurrent.BlockingQueue;

/**
 * Created by mami01 on 05/03/14.
 * Producer class that will create messages and put it in the queue.
 */
public class Producer implements Runnable {

    private BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        //produce messages
        for(int i=0; i<15; i++) {
            Message msg = new Message(""+i);
            try{
                Thread.sleep(i);
                queue.put(msg);// it will wait if there's no space available to put the message
                // we can use offer(e, time, unit) o wait for certain time
                System.out.println("Produced " + msg.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //adding exit message
        Message msg = new Message("exit");
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

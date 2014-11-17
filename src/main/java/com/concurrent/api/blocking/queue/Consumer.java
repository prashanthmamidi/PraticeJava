package com.concurrent.api.blocking.queue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by mami01 on 05/03/14.
 *
 * Consumer class that will process on the messages from the queue and terminates when exit message is received.
 *
 */
public class Consumer implements Runnable{
    private BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        //consuming messages until exit message is received
        try{
            Message msg;
            //queue.take() - will wait indefinately if no elements exists, use poll(time, unit) to wait for specified time,
            while((msg = queue.take()).getMsg() != "exit") {
                Thread.sleep(2000);
                System.out.println("Consumed " + msg.getMsg());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

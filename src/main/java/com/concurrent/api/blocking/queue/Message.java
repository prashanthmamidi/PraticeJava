package com.concurrent.api.blocking.queue;

/**
 * Created by mami01 on 05/03/14.
 * Ref: http://www.journaldev.com/1034/java-blockingqueue-example-implementing-producer-consumer-problem *
 *
 * Just a normal java object that will be produced by Producer and added to the queue.
 */
public class Message {
    private String msg;

    public Message(String str){
        this.msg=str;
    }

    public String getMsg() {
        return msg;
    }

}

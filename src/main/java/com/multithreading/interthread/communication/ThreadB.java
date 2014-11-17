package com.multithreading.interthread.communication;

/**
 * Created by mami01 on 27/02/14.
 */
public class ThreadB extends Thread {
    int total;
    @Override
    public void run(){
        synchronized(this){
            for(int i=0; i<100 ; i++){
                total += i;
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Before notify");
           // notify();
            System.out.println("After notify");
        }
    }
}

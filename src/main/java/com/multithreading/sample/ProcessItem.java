package com.multithreading.sample;

import java.lang.management.ThreadInfo;

/**
 * Created by mami01 on 27/02/14.
 */
public class ProcessItem implements Runnable {

    private String itemName;
    private String returnValue;

    public ProcessItem(String itemName) {
        this.itemName = itemName;
    }
    @Override
    public void run() {
        // call to DB to process item
        //dao.processItem(itemName);
        System.out.println("Calling DB to process Item...");

        try {
            Thread.sleep(5000);
            System.out.println("DB process completed for process Item..." + ThreadInfo.class);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        returnValue = "anshik";
    }

    public String getReturnValue() {
        return returnValue;
    }
}

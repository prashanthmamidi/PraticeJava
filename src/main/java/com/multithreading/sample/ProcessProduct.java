package com.multithreading.sample;

import java.lang.management.ThreadInfo;

/**
 * Created by mami01 on 27/02/14.
 */
public class ProcessProduct implements Runnable {
    private final String productName;

   public ProcessProduct(String productName) {
        this.productName = productName;
    }
    @Override
    public void run() {
        // call to DB to process product
        //dao.processProduct(productName);
        System.out.println("Calling DB to process Product...");

        try {
            Thread.sleep(1000);
            System.out.println("DB process completed for process Product..." + ThreadInfo.class);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

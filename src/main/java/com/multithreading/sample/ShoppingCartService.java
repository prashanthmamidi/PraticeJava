package com.multithreading.sample;

/**
 * Created by mami01 on 27/02/14.
 */
public class ShoppingCartService {

    private String itemName;
    private String productName;

    public ShoppingCartService(String itemName, String productName) {
        this.itemName = itemName;
        this.productName = productName;
    }

    public String processOrder() throws InterruptedException {
        System.out.println("ProcessItem :: Creating Thread ....");
        ProcessItem item = new ProcessItem(itemName);
        Thread processItem = new Thread(item);
        processItem.start();
        System.out.println("ProcessItem :: Thread started....");

        System.out.println("ProcessProduct :: Creating Thread ....");
        Thread processProduct = new Thread(new ProcessProduct(productName));
        processProduct.start();
        System.out.println("ProcessProduct :: Thread started....");

        //Before return ensures both the threads are completed
        System.out.println("Waiting for processItem to complete...");
        processItem.join();
        System.out.println("processItem completed...");

        System.out.println("return got " + item.getReturnValue());

        System.out.println("Waiting for processProduct to complete...");
        processProduct.join();
        System.out.println("processProduct completed...");


        return "success";
    }
}

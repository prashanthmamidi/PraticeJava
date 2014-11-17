package com.multithreading.sample;

/**
 * Created by mami01 on 27/02/14.
 */
public class TestMultithread {

    public static void main(String[] args) throws InterruptedException {
        ShoppingCartService shoppingCartService = new ShoppingCartService("Samuhik", "Public");
        shoppingCartService.processOrder();
    }
}

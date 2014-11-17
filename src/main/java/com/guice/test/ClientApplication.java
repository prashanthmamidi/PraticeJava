package com.guice.test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.guice.consumer.MyApplication;
import com.guice.injector.AppInjector;

/**
 * Created by mami01 on 14/03/14.
 */
public class ClientApplication {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AppInjector());

        MyApplication app = injector.getInstance(MyApplication.class);

        app.sendMessage("Hi Samuhik", "samu@anchik.com");
    }
}

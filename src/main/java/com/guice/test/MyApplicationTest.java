package com.guice.test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.guice.consumer.MyApplication;
import com.guice.services.MessageService;
import com.guice.services.MockMessageService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mami01 on 14/03/14.
 */
public class MyApplicationTest {

    private Injector injector;

    @Before
    public void setup() throws Exception {
        injector = Guice.createInjector(new AbstractModule(){
            @Override
            protected void configure() {
                bind(MessageService.class).to(MockMessageService.class);
            }
        });
    }

    @After
    public void tearDown() throws Exception {
        injector = null;
    }

    @Test
    public void test() {
        MyApplication appTest = injector.getInstance(MyApplication.class);

        Assert.assertEquals(true, appTest.sendMessage("Hi Pankaj", "pankaj@abc.com"));;
    }
}

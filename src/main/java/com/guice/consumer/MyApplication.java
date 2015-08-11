package com.guice.consumer;

import com.guice.services.MessageService;

import javax.inject.Inject;

/**
 * Created by mami01 on 14/03/14.
 */
public class MyApplication {

    private MessageService service;

    //  constructor based injector
//  @Inject
//  public MyApplication(MessageService svc){
//      this.service=svc;
//  }
//setter method injector
    @Inject
    public void setService(MessageService svc){
        this.service = svc;
    }

    public boolean sendMessage(String msg, String rec) {
        //some business logic here
        return service.sendMessage(msg, rec);
    }

}
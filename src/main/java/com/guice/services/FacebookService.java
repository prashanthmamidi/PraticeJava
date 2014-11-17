package com.guice.services;

import com.google.inject.Singleton;

/**
 * Created by mami01 on 14/03/14.
 */
@javax.inject.Singleton
public class FacebookService implements MessageService {
    @Override
    public boolean sendMessage(String msg, String receipient) {
        //some complex code to send Facebook message
        System.out.println("Message sent to Facebook user " + receipient +" with message="+msg);
        return true;
    }
}

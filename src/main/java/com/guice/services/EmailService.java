package com.guice.services;

import javax.inject.Singleton;

/**
 * Created by mami01 on 14/03/14.
 * http://www.journaldev.com/2403/google-guice-dependency-injection-example-tutorial
 */
@Singleton
public class EmailService implements MessageService {
    @Override
    public boolean sendMessage(String msg, String receipient) {
        //some fancy code to send email
        System.out.println("Email Message sent to "+receipient+" with message="+msg);
        return true;
    }
}

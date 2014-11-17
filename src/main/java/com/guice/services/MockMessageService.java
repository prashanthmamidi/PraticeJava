package com.guice.services;

/**
 * Created by mami01 on 14/03/14.
 */
public class MockMessageService implements MessageService {
    @Override
    public boolean sendMessage(String msg, String receipient) {
        return true;
    }
}

package com.jms.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by mami01 on 11/03/14.
 */
public class MessageListenerImpl implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("RECEIVER...");
        TextMessage msg = (TextMessage) message;
        try {
            System.out.println("MESSAGE: " + msg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("LISTNER STARTED");
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "JMSConfig.xml" });
    }
}

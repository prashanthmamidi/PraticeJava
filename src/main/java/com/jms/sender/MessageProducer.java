package com.jms.sender;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.Scanner;

/**
 * Created by mami01 on 11/03/14.
 */
public class MessageProducer {
    protected JmsTemplate jmsTemplate;
    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessages(final String msg) throws JMSException {
        System.out.println("PRODUCER...");
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage(msg);
                return message;
            }
        };
        jmsTemplate.send(messageCreator);
    }

    public static void main(String[] args) throws JMSException {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "JMSConfig.xml" });
        MessageProducer myBean = (MessageProducer) context.getBean("simpleMessageProducer");
        while(true) {
            System.out.println("Type the message to put in the Queue :: ");
            Scanner scanner = new Scanner(System.in);
            String inputMsg = scanner.nextLine();
            if (inputMsg.equalsIgnoreCase("exit"))
                return;
            myBean.sendMessages(inputMsg);
        }
    }
}

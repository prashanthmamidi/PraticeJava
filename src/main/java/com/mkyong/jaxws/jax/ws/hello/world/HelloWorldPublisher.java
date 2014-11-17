package com.mkyong.jaxws.jax.ws.hello.world;

import javax.xml.ws.Endpoint;

/**
 * Created by mami01 on 27/05/14.
 */

//Endpoint publisher
public class HelloWorldPublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());
    }
}

package com.mkyong.jaxws.jax.ws.hello.world;

import javax.jws.WebService;

/**
 * Created by mami01 on 27/05/14.
 */

//Service Implementation
@WebService(endpointInterface = "com.mkyong.jaxws.jax.ws.hello.world.HelloWorld")
public class HelloWorldImpl implements HelloWorld{
    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello World JAX-WS " + name;
    }
}

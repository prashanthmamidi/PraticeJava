package com.mkyong.jaxws.jax.ws.client;

import com.mkyong.jaxws.jax.ws.hello.world.HelloWorld;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by mami01 on 28/05/14.
 */
public class HelloWorldClient {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:9999/ws/hello?wsdl");

        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qName = new QName("http://world.hello.ws.jax.jaxws.mkyong.com/", "HelloWorldImplService");

        Service service = Service.create(url, qName);

        HelloWorld hello = service.getPort(HelloWorld.class);

        System.out.println(hello.getHelloWorldAsString("Vishnutej Reddy Mamidi"));

    }
}

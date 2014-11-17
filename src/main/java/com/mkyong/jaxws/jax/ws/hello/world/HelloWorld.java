package com.mkyong.jaxws.jax.ws.hello.world;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by mami01 on 27/05/14.
 */
//Service Endpoint Interface
@WebService
@SOAPBinding (style = SOAPBinding.Style.RPC)
public interface HelloWorld {

    @WebMethod(operationName = "getHelloWorldAsString")
    String getHelloWorldAsString(String name);

}

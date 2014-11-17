package com.guice.injector;

import com.google.inject.AbstractModule;
import com.guice.services.FacebookService;
import com.guice.services.MessageService;


/**
 * Created by mami01 on 14/03/14.
 */
public class AppInjector extends AbstractModule {
    @Override
    protected void configure() {
        //bind the service to implementation class
        //bind(MessageService.class).to(EmailService.class);

        //bind MessageService to Facebook Message implementation
        bind(MessageService.class).to(FacebookService.class);
    }
}

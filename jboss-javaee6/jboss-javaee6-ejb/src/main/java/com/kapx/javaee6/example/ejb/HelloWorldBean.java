package com.kapx.javaee6.example.ejb;

import javax.annotation.Resource;
import javax.ejb.*;

import org.jboss.security.annotation.SecurityDomain;

@Stateless
@Remote(HelloWorldRemote.class)
@SecurityDomain("jmx-console")
public class HelloWorldBean implements HelloWorldRemote {

    @Resource
    private SessionContext sessionContext;

    @Override
    public String sayHello(String arg) {
        System.out.println("Call to HelloWorldBean with argument " + arg);

        return "Hello !!! " + arg;
    }

    public String sayHelloSecure(String arg) {
        System.out.println("Call to HelloWorldBean secure method with argument " + arg);

        return "Hello !!! " + arg;
    }
}

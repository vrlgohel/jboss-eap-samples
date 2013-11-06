package com.kapx.javaee6.example.ejb;

public interface HelloWorldRemote {
    String sayHello(String arg);

    String sayHelloSecure(String arg);
}

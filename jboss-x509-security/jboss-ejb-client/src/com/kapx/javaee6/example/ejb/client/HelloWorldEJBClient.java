package com.kapx.javaee6.example.ejb.client;

import java.util.Properties;

import javax.naming.*;

import com.kapx.javaee6.example.ejb.HelloWorldRemote;

public class HelloWorldEJBClient {

    public static void main(String[] args) {
        try {
            HelloWorldRemote remote = performHelloWorldRemoteLookup();
            System.out.println(remote.sayHello("Kapx"));
            System.out.println(remote.sayHelloSecure("Kapx"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static HelloWorldRemote performHelloWorldRemoteLookup() throws NamingException {

        final String PKG_INTERFACES = "org.jboss.ejb.client.naming";

        Properties props = new Properties();
        props.put(Context.URL_PKG_PREFIXES, PKG_INTERFACES);
        props.put("jboss.naming.client.ejb.context", true);

        props.put("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
        props.put("java.naming.provider.url", "remote://127.0.0.1:4447");
        props.put("jboss.naming.client.ejb.context", "true");
        props.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT", "false");

        // FIXME: SSL related config parameters
        props.put("jboss.naming.client.remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", "true");
        props.put("jboss.naming.client.connect.options.org.xnio.Options.SSL_STARTTLS", "true");

        props.put(Context.SECURITY_PRINCIPAL, "admin");
        props.put(Context.SECURITY_CREDENTIALS, "testing");

        defineSystemProperties();

        Context context = new InitialContext(props);

        HelloWorldRemote remote = (HelloWorldRemote) context.lookup(getJndiName());
        return remote;
    }

    private static String getJndiName() {
        final String appName = "jboss-javaee6";
        final String moduleName = "jboss-javaee6-ejb-0.0.1-SNAPSHOT";
        final String beanName = "HelloWorldBean";
        String jndiName = "ejb:" + appName + "/" + moduleName + "/" + beanName + "!com.kapx.javaee6.example.ejb.HelloWorldRemote";
        return jndiName;
    }

    public static void defineSystemProperties() {
        System.setProperty("javax.net.ssl.keyStore", "C:/Local/KAPIL/TechStuff/MyWorkspaces/jboss-javaee6-workspace/jboss-ejb-client/conf/client-keystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "changeit");

        System.setProperty("javax.net.ssl.trustStore", "C:/Local/KAPIL/TechStuff/MyWorkspaces/jboss-javaee6-workspace/jboss-ejb-client/conf/client-truststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
    }
}

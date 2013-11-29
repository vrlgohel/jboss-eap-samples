package com.kapx.jboss.javaee6.ejb;

//import static org.junit.Assert.assertEquals;
//
//import javax.ejb.EJB;
//
//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.arquillian.junit.InSequence;
//import org.jboss.shrinkwrap.api.Archive;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.spec.WebArchive;
//import org.junit.Test;
//import org.junit.runner.RunWith;

//@RunWith(Arquillian.class)
public class HelloWorldBeanTest {
	// @Deployment(name = "jboss-javaee6-war")
	// public static Archive<?> createTestArchive() {
	// final WebArchive war = ShrinkWrap.create(WebArchive.class,
	// "jboss-javaee6-webapp.war");
	// // war.addClass(HelloWorldLocal.class);
	// // war.addClass(HelloWorldRemote.class);
	// // war.addClass(HelloWorldBean.class);
	// war.addAsWebInfResource("META-INF/beans.xml");
	// return war;
	// }

	// @EJB(mappedName =
	// "jboss-blank-webapp/HelloWorldBean!com.kapx.jboss.javaee6.ejb.HelloWorldRemote")
	// private HelloWorldRemote helloWorldEJB;

	// @Test
	// @InSequence(1)
	// public void test_sayHello() {
	// String actual = helloWorldEJB.sayHello("Kapx");
	// System.out.println("Response: " + actual);
	// assertEquals("Hello !!! Kapx", actual);
	// }
}

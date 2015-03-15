package org.diosoft.spring.core.hw4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yar on 27.02.15.
 */
public class SimpleMain {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("hw2/application-context.xml");
//        context.registerShutdownHook();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

//        context.getBean(Observer.class).notifyObserver(new Message("dsds","dsdsd"));
    }
}

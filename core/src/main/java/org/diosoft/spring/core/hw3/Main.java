package org.diosoft.spring.core.hw3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yar on 02.03.15.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/hw3/application-context.xml");
        context.registerShutdownHook();
    }
}

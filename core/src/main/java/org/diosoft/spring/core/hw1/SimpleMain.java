package org.diosoft.spring.core.hw1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yar on 27.02.15.
 */
public class SimpleMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("hw1/application-context.xml");
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        context.scan("org.diosoft.spring.core");
//            SimpleSubject subject = context.getBean(SimpleSubject.class);
            for(int i=0; i<10;i++){
                context.getBean(SimpleObserver.class);
            }
        context.getBean(SimpleUserObserver.class);
//        context.getBean(Observer.class);

    }
}

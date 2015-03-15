package org.diosoft.spring.core.lesson4;

import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yar on 27.02.15.
 */
public class SimpleMain {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("lesson4/application-context.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        context.registerShutdownHook();

//        context.getBean(SimpleObserver.class);

//        for(int i=0; i<5; i++){
//            System.out.println("Init bean");
//            context.getBean(Observer.class);
//        }
//        context.getBean(SimpleUserObserver.class);
    }
}

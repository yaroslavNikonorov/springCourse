package org.diosoft.spring.core.lesson2;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yar on 24.02.15.
 */
//local code review (vtegza): clean up code @ 01.03.15
public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        context.registerShutdownHook();

        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setInitMethodName("init");
        beanDefinition.setBeanClass(ConcreteSubject.class);
        beanDefinition.setLazyInit(false);
        beanDefinition.setAbstract(false);
        beanDefinition.setAutowireCandidate(true);
        beanDefinition.setScope("prototype");
        beanFactory.registerBeanDefinition("MyNewSubject", beanDefinition);

        ConcreteSubject s1 = context.getBean("MyNewSubject", ConcreteSubject.class);
        s1.print("dsdsdsd");


//        callContext("aaa");
//        callContext("bbb");
    }

//    private static void callContext(String value){
//        BeanFactoryLocator bfl = ContextSingletonBeanFactoryLocator.getInstance();
//        BeanFactoryReference bfr = bfl.useBeanFactory("mainContext");
//
//        ConcreteSubject subject = bfr.getFactory().getBean(ConcreteSubject.class);
//        subject.print(value);
//    }
}

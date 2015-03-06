package org.diosoft.spring.core.hw2;

import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yar on 27.02.15.
 */
public class SimpleMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("hw2/application-context.xml");
        context.registerShutdownHook();
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        context.scan("org.diosoft.spring.core");
//            SimpleSubject subject = context.getBean(SimpleSubject.class);
//            for(int i=0; i<10;i++){
//                context.getBean(SimpleObserver.class);
//            }




        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setInitMethodName("init");
        beanDefinition.setBeanClass(DetailedObserver.class);
        beanDefinition.setLazyInit(false);
        beanDefinition.setAbstract(false);
        beanDefinition.setAutowireCandidate(true);
        beanDefinition.setScope("prototype");
        ConstructorArgumentValues constructorArgumentValues = new ConstructorArgumentValues();
        constructorArgumentValues.addGenericArgumentValue(context.getBean(SimpleSubject.class));
        beanDefinition.setConstructorArgumentValues(constructorArgumentValues);
        beanFactory.registerBeanDefinition("DetailedObserver", beanDefinition);




        DetailedObserver s1 = context.getBean("DetailedObserver", DetailedObserver.class);

//        context.getBean(SimpleUserObserver.class);
//        context.getBean(Observer.class);

    }
}

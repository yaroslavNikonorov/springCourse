package org.diosoft.spring.core.lesson2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yar on 23.02.15.
 */
//@Component
public class ConcreteSubject implements Subject, BeanNameAware, BeanFactoryAware, ApplicationContextAware, BeanPostProcessor, InitializingBean, DisposableBean{
    private List<Observer> observers = new ArrayList<>();
    private int initOrder=1;


    public ConcreteSubject() {
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);

    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Message message) {
        for (Observer observer : observers) {
            observer.notifyObserver(message);
        }
    }

    @Override
    public void setBeanName(String s) {
        System.out.println(initOrder+++": Bean Name: "+s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(initOrder+++": Bean Factory Aware");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(initOrder+++": Application Context Aware");
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println(initOrder+++": Before Initialization, "+s);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println(initOrder+++": After Initialization, Object: "+o.getClass().getName()+", String: "+s);
        return o;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(initOrder+++": After properties set");
    }

    @PostConstruct
    public void init(){
        System.out.println(initOrder+++": Init method");
    }
    @PreDestroy
    public void preDestroy(){
        System.out.println(initOrder+++": PreDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(initOrder+++": Destroy");
    }

    public void print(String str){
        System.out.println(str);
    }
}

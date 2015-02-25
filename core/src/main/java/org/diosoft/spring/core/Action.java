package org.diosoft.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by yar on 25.02.15.
 */
@Component
public class Action {

    @Autowired
    private Subject subject;

    @Autowired
    private ApplicationContext context;

    @PostConstruct
    public void start(){
        for(int i=0; i<10; i++) {
//            subject.register(context.getBean(Observer.class));
            context.getBean(Observer.class);
        }
//        subject.notifyObservers();
    }
}

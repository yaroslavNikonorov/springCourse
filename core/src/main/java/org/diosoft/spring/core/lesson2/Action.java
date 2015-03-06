package org.diosoft.spring.core.lesson2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by yar on 25.02.15.
 */
//local code review (vtegza): clean up @ 01.03.15
//@Component
public class Action implements ApplicationContextAware {

    private Subject subject;
    private ApplicationContext context;


//    @PostConstruct
    public void start() {
//        for (int i = 0; i < 10; i++) {
//            subject.register(context.getBean(Observer.class));
//            context.getBean(ConcreteObserver.class);
//        }
//        subject.notifyObservers();


        context.getBean(Subject.class);
//        context.getBean(ConcreteObserver.class);
//        context.getBean(UserObserver.class);
    }

    public Subject getSubject() {
        return subject;
    }

    @Autowired
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context=applicationContext;
    }
}

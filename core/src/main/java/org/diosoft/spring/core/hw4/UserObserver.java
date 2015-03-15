package org.diosoft.spring.core.hw4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yar on 25.02.15.
 */
@Component
//@Scope("prototype")
public class UserObserver implements Observer {
    private String name="UserObserver";
    private Subject subject;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private UserObserverHelper userObserverHelper;


    @Autowired
    public UserObserver(Subject subject, UserObserverHelper userObserverHelper) {
        this.subject=subject;
        this.userObserverHelper=userObserverHelper;
        subject.register(this);
        userObserverHelper.init();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

//    @Autowired
    public void setSubject(Subject subject) {
        this.subject = subject;
        subject.register(this);
    }

    @Override
    public void notifyObserver(Message message) {
        System.out.println(name + " observer:" + " Subject: " + message.getSubject() + ", Details: " + message.getDetails()+", Thread: "+Thread.currentThread().getName());
    }
}

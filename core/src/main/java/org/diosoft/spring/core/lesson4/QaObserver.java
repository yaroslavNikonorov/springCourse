package org.diosoft.spring.core.lesson4;

import org.diosoft.spring.core.lesson2.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
@Profile("qa")
public class QaObserver implements Observer {
    private static Integer id = 0;
    private String name = "QaObserver" + id++;

    private Subject subject;

    @Autowired
    public QaObserver(Subject subject) {
        this.subject=subject;
        subject.register(this);
        System.out.println(name+" Initialized");
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
//        subject.register(this);
    }

    @Override
    public void notifyObserver(Message message) {
        System.out.println(name + " observer: " + "Subject: " + message.getSubject() + ", Details: " + message.getDetails()+", Thread: "+Thread.currentThread().getName());
    }
}

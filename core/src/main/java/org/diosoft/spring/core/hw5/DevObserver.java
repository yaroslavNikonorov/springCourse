package org.diosoft.spring.core.hw5;


import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DevObserver implements Observer, BeanNameAware {
    private String name;

    private Subject subject;

    @Autowired
    @Qualifier("devHelper")
    private Helper helper;

    @Autowired
    private MessageOut messageOut;

    @Autowired
    public DevObserver(Subject subject) {
        this.subject=subject;
        subject.register(this);
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

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void notifyObserver(Message message) {
        messageOut.print("Observer "+name+", "+helper.prepare(message));
    }

    @Override
    public void setBeanName(String s) {
        name=s;
    }
}

package org.diosoft.spring.core.hw5;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yar on 25.02.15.
 */
@Component
@DependsOn({"devObserver", "qaObserver"})
public class UserObserver implements Observer, BeanNameAware {
    private String name;
    private Subject subject;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Autowired
    @Qualifier("userHelper")
    private Helper helper;

    @Autowired
    private MessageOut messageOut;


    @Autowired
    public UserObserver(Subject subject) {
        this.subject = subject;
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

    //    @Autowired
    public void setSubject(Subject subject) {
        this.subject = subject;
        subject.register(this);
    }

    @Override
    public void notifyObserver(Message message) {
        messageOut.print("Observer " + name + ", " + helper.prepare(message));
    }

    @Override
    public void setBeanName(String s) {
        name = s;
    }

    @PostConstruct
    public void init() {
        try {
            String msg;
            while ((msg = br.readLine()) != null) subject.notifyObservers(new Message(name, msg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

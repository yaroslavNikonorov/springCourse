package org.diosoft.spring.hw1;

import org.diosoft.spring.core.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yar on 25.02.15.
 */
//@Component
//@Scope("prototype")
public class SimpleUserObserver implements Observer {
    private String name="User";
    private Subject subject;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//    @Autowired
    public SimpleUserObserver(Subject subject) {
        this.subject=subject;
        subject.register(this);
        System.out.println(name+" Initialized");
//        init();
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
        System.out.println(name + " observer:" + " Subject: " + message.getSubject() + ", Details: " + message.getDetails());
    }

//    @PostConstruct
    public void init(){
        try {
            while (true) subject.notifyObservers(new Message("From " + name, br.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package org.diosoft.spring.core.hw1;

import org.diosoft.spring.core.lesson2.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yar on 25.02.15.
 */
//local code review (vtegza): clean up, separate by packages and duplicate class to preform different laboratory work ) @ 01.03.15
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
        System.out.println(name + " observer:" + " Subject: " + message.getSubject() + ", Details: " + message.getDetails()+", Thread: "+Thread.currentThread().getName());
    }

//    @PostConstruct
    public void init(){
        try {
            String msg;
            while ((msg=br.readLine())!=null) subject.notifyObservers(new Message("From " + name, msg));
        } catch (IOException e) {
            e.printStackTrace();
        }
        subject.unregister(this);
    }
}

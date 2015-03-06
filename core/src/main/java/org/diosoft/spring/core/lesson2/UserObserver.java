package org.diosoft.spring.core.lesson2;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yar on 25.02.15.
 */
//@Component
//@Scope("prototype")
public class UserObserver implements Observer, Runnable {
    private String name;
    //local code review (vtegza): annotate constructor with Subject bean as parameter @ 01.03.15
    @Autowired
    private Subject subject;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public UserObserver() {
//        new Thread(this).start();
        subject.register(this);
        run();
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

    @Override
    public void run() {
        try {
            while (subject == null) Thread.sleep(100);
            subject.register(this);
            while (!Thread.interrupted()) subject.notifyObservers(new Message("From " + name, br.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

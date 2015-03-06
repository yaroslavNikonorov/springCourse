package org.diosoft.spring.core.lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope("prototype")
public class ConcreteObserver implements Observer, Runnable {

    //local code review (vtegza): create generator object and inject it as dependency @ 01.03.15
    private static Integer id = 0;
    private String name = "Observer" + id++;
    private Random random = new Random();
    //local code review (vtegza): you can use this annotation on constructor = so you will have autowired beans and good design @ 01.03.15
    @Autowired
    private Subject subject;

    public ConcreteObserver() {
        subject.register(this);
        System.out.println(name+" Initialized");
        new Thread(this).start();
    }

    public ConcreteObserver(String name) {
        this.name = name;
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
//local code review (vtegza): take a look at Mediator patterns - normally tou would prefer 3rd party bean to register observer on subject @ 01.03.15
    public void setSubject(Subject subject) {
        this.subject = subject;
        subject.register(this);
    }

    @Override
    public void notifyObserver(Message message) {
        System.out.println(name + " observer: " + "Subject: " + message.getSubject() + ", Details: " + message.getDetails());
    }

    private void sendMessage() {
        Message message = new Message("From " + name, randomString());
        subject.notifyObservers(message);
    }

    private String randomString() {
        StringBuilder sb = new StringBuilder();
        int length = random.nextInt(10);
        for (int i = 0; i < length; i++) {
            sb.append((char) (97 + random.nextInt(25)));
        }
        return sb.toString();
    }

    @Override
    public void run() {
        try {
            while (subject == null) Thread.sleep(100);
            subject.register(this);
            int count = 0;
            while (!Thread.interrupted() && count < 10) {
                sendMessage();
                Thread.sleep(1000 + random.nextInt(10000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        subject.unregister(this);
    }
}

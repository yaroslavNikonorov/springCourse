package org.diosoft.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yar on 25.02.15.
 */
public class UserObserver implements Observer, Runnable{
    private String name;
    @Autowired
    private Subject subject;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public UserObserver() {
        new Thread(this).start();
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
        System.out.println(name+" observer:"+" Subject: "+message.getSubject()+", Details: "+message.getDetails());
    }

    @Override
    public void run() {
        try {
            while (subject==null) Thread.sleep(100);
            subject.register(this);
            while (!Thread.interrupted()) subject.notifyObservers(new Message("From "+name, br.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

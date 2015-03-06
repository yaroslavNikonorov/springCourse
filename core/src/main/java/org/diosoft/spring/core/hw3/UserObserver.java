package org.diosoft.spring.core.hw3;


import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yar on 25.02.15.
 */
public class UserObserver implements ApplicationListener<ObserverEvent>, BeanNameAware {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private String name;
    private Subject subject;

    public UserObserver(Subject subject) {
        this.subject=subject;
    }

    public void init(){
        try {
            String msg;
            while ((msg=br.readLine())!=null) subject.notifyAllObservers(new Message("From " + name, msg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onApplicationEvent(ObserverEvent observerEvent) {
        System.out.println("Message for "+name+", message: "+observerEvent.getSource());
    }

    @Override
    public void setBeanName(String s) {
        this.name=s;
    }
}

package org.diosoft.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yar on 23.02.15.
 */
@Component
public class ConcreteSubject implements Subject {
    private List<Observer> observers=new ArrayList<>();
    public ConcreteSubject() {
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);

    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Message message) {
        for(Observer observer: observers){
            observer.notifyObserver(message);
        }
    }
}

package org.diosoft.spring.core.hw5;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yar on 23.02.15.
 */
@Component
public class SubjectImpl implements Subject{
    private List<Observer> observers = new ArrayList<>();

    public SubjectImpl() {
        System.out.println("Subject Initialized");
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
        for (Observer observer : observers) {
            observer.notifyObserver(message);
        }
    }
}

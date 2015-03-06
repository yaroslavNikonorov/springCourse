package org.diosoft.spring.core.hw2;

import org.diosoft.spring.core.lesson2.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yar on 23.02.15.
 */
//@Component
public class SimpleSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();

    public SimpleSubject() {
        System.out.println("Init Simple Subject");
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

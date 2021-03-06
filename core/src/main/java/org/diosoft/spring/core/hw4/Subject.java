package org.diosoft.spring.core.hw4;


/**
 * Created by yar on 23.02.15.
 */
public interface Subject {
    void register(Observer observer);

    void unregister(Observer observer);

    void notifyObservers(Message message);
}

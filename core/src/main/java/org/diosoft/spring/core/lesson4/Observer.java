package org.diosoft.spring.core.lesson4;

import org.diosoft.spring.core.lesson2.Message;

/**
 * Created by yar on 23.02.15.
 */
public interface Observer {
    void notifyObserver(Message message);
}

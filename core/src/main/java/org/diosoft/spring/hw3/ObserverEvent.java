package org.diosoft.spring.hw3;


import org.springframework.context.ApplicationEvent;

/**
 * Created by yar on 02.03.15.
 */
public class ObserverEvent extends ApplicationEvent {

    public ObserverEvent(Message source) {
        super(source);
    }

    @Override
    public Message getSource() {
        return (Message) super.getSource();
    }
}

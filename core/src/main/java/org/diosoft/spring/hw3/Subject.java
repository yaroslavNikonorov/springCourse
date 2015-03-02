package org.diosoft.spring.hw3;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * Created by yar on 02.03.15.
 */
public class Subject implements  ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher=applicationEventPublisher;
    }

    public void notifyAllObservers(Message message){
        applicationEventPublisher.publishEvent(new ObserverEvent(message));
    }
}

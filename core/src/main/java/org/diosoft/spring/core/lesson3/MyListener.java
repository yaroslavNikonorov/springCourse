package org.diosoft.spring.core.lesson3;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

/**
 * Created by yar on 02.03.15.
 */
public class MyListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        System.out.println("Event occured"+contextClosedEvent);
    }
}

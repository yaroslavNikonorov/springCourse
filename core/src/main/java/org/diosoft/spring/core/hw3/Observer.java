package org.diosoft.spring.core.hw3;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationListener;

/**
 * Created by yar on 02.03.15.
 */
public class Observer implements ApplicationListener<ObserverEvent>, BeanNameAware {
    private String name;
    @Override
    public void onApplicationEvent(ObserverEvent observerEvent) {
        System.out.println("Message for "+name+", message: "+observerEvent.getSource());
    }

    @Override
    public void setBeanName(String s) {
        this.name=s;
    }
}

package org.diosoft.spring.core.hw5;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("devHelper")
public class DevHelperImpl implements Helper, BeanNameAware {

    private String helperName;
    @Override
    public String prepare(Message message) {
        return "HelperName: "+helperName+", Message from: "+ message.getFrom()+", Message: "+message.getMessage();
    }

    @Override
    public void setBeanName(String s) {
        helperName=s;
    }
}

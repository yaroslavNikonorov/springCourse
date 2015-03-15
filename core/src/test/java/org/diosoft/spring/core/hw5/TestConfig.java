package org.diosoft.spring.core.hw5;

import org.diosoft.spring.core.hw4.*;
import org.springframework.context.annotation.*;

/**
 * Created by yar on 15.03.15.
 */
@Configuration
public class TestConfig {

    @Bean
    public Subject subject(){
        return new SubjectImpl();
    }

    @Bean
    public StringMessageOut stringMessageOut(){
        return new StringMessageOut();
    }

    @Bean
    @Profile("dev")
    public DevHelperImpl devHelper(){
        return new DevHelperImpl();
    }

    @Bean
    @Profile("qa")
    public QaHelperImpl qaHelper(){
        return new QaHelperImpl();
    }

    @Bean
    @Profile("dev")
    public DevObserver devObserver(){
        return new DevObserver(subject());
    }

    @Bean
    @Profile("qa")
    public QaObserver qaObserver(){
        return new QaObserver(subject());
    }
}

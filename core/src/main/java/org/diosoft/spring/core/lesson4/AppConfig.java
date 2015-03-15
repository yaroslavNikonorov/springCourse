package org.diosoft.spring.core.lesson4;

import org.diosoft.spring.core.hw3.UserObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

/**
 * Created by yar on 06.03.15.
 */
@Configuration
@PropertySource("classpath:/lesson4/bean.properties")
public class AppConfig {
//
//    @Value("bean.simple")
//    private String mmm;
//
//    @Bean
//    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(){
//        return new PropertyPlaceholderConfigurer();
//    }

    @Bean
    public Subject subject(){
//        System.out.println(mmm);
        return new SimpleSubject();
    }

    @Bean
//    @Scope("prototype")
    @Conditional(SimpleConditional.class)
    public Observer simpleObserver(){
        return new SimpleObserver(subject());
    }

//    @Bean
//    @Scope("prototype")
//    public Observer userObserver(){
//        return new SimpleUserObserver(subject());
//    }

}

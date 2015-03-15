package org.diosoft.spring.core.hw4;

import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

/**
 * Created by yar on 12.03.15.
 */
@Configuration
@ComponentScan("org.diosoft.spring.core.hw4")
@PropertySource("hw4/bean.properties")
public class AppConfig {

    @Bean
    public Subject simpleSubject(){
        return new SimpleSubject();
    }

    @Bean
    @Primary
    public UserObserverHelperImpl1 userObserverHelperImpl1(){
        return new UserObserverHelperImpl1(simpleSubject());
    }

    @Bean UserObserverHelperImpl2 userObserverHelperImpl2(){
        return new UserObserverHelperImpl2(simpleSubject());
    }
//    @Bean
//    @DependsOn({"devObserver", "qaObserver"})
//    @Order(300)
//    @Scope("prototype")
//    public UserObserver userObserver(){
//        return new UserObserver(simpleSubject());
//    }

    @Bean(name = "dev")
//    @Order(200)
//    @Scope("prototype")
//    @Profile("dev")
//    @Primary
    @Conditional(ConditionalObserver.class)
    public DevObserver devObserver(){
        return new DevObserver(simpleSubject());
    }

    @Bean(name = "qa")
//    @Scope("prototype")
//    @Profile("qa")
//    @Primary
//    @Conditional(ConditionalObserver.class)
    public QaObserver qaObserver(){
        return new QaObserver(simpleSubject());
    }


}

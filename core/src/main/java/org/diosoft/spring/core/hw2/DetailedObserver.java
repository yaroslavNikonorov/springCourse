package org.diosoft.spring.core.hw2;

import org.diosoft.spring.core.lesson2.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;

//@Component
//@Scope("prototype")
public class DetailedObserver implements Observer, BeanNameAware, BeanPostProcessor, InitializingBean, DisposableBean {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    private Integer id = 0;
    private String name = "Detailed Observer";

    private Subject subject;

//    @Autowired
    public DetailedObserver(Subject subject) {
        this.subject=subject;
        subject.register(this);
        System.out.println(name+" Initialized");
        log.info(id+++". Constructor");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

//    @Autowired
    public void setSubject(Subject subject) {
        this.subject = subject;
//        subject.register(this);
    }

    @Override
    public void notifyObserver(Message message) {
        System.out.println(name + " observer: " + "Subject: " + message.getSubject() + ", Details: " + message.getDetails()+", Thread: "+Thread.currentThread().getName());
    }

    @Override
    public void setBeanName(String s) {
        log.info(id+++". Bean name: "+s);
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        log.info(id+++". Before Initialization, Bean: "+s+", Object: "+o.getClass().getName());
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        log.info(id+++". After Initialization, Bean: "+s+", Object: "+o.getClass().getName());
        return o;
    }

    @Override
    public void destroy() throws Exception {
        log.info(id+++". Destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(id+++". After properties set");
    }

    public void init(){
        log.info(id+++". Init Method");
    }
}

package org.diosoft.spring.core.lesson4;

import org.diosoft.spring.core.lesson2.Message;

//@Component
//@Scope("prototype")
public class SimpleObserver implements Observer {
    private static Integer id = 0;
    private String name = "Observer" + id++;

    private Subject subject;

//    @Autowired
    public SimpleObserver(Subject subject) {
        this.subject=subject;
        subject.register(this);
        System.out.println(name+" Initialized");
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
}

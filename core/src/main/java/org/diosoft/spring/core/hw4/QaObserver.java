package org.diosoft.spring.core.hw4;

//@Component
//@Scope("prototype")
public class QaObserver implements Observer {
//    private static Integer id = 0;
    private String name = "QaObserver";

    private Subject subject;

//    @Autowired
    public QaObserver(Subject subject) {
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

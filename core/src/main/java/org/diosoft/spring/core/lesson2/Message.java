package org.diosoft.spring.core.lesson2;

/**
 * Created by yar on 25.02.15.
 */
public class Message {
    private String subject;
    private String details;

    public Message(String subject, String details) {
        this.subject = subject;
        this.details = details;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

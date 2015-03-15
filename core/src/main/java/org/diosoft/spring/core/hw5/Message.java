package org.diosoft.spring.core.hw5;

/**
 * Created by yar on 25.02.15.
 */
public class Message {
    private String from;
    private String message;

    public Message(String from, String message) {
        this.from = from;
        this.message = message;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

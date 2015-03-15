package org.diosoft.spring.core.hw5;

public class StringMessageOut implements MessageOut {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void print(String message) {
        setMessage(message);
    }
}

package org.diosoft.spring.core.hw5;

import org.springframework.stereotype.Component;

import java.io.PrintStream;

@Component
public class ConsoleMessageOut implements MessageOut {

    private PrintStream printStream = System.out;

    @Override
    public void print(String message) {
        printStream.println(message);
    }
}

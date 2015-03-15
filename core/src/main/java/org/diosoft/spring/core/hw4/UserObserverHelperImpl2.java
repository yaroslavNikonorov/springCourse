package org.diosoft.spring.core.hw4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yar on 12.03.15.
 */
public class UserObserverHelperImpl2 implements UserObserverHelper {

    private Subject subject;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public UserObserverHelperImpl2(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void init() {
        try {
            String msg;
            while ((msg=br.readLine())!=null) subject.notifyObservers(new Message("From " + "Helper2", msg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

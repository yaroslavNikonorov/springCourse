package org.diosoft.spring.core.hw5;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by yar on 13.03.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@ActiveProfiles({"dev"})
public class DevObserverTest {

    @Autowired
    private Subject subject;

    @Autowired
    private StringMessageOut stringMessageOut;

    @Before
    public void sendMessage() {
        System.out.println("DevObserverTest");
    }

    @Test
    public void simpleMessageTest(){
        subject.notifyObservers(new Message("test", "test"));
        assertEquals("Observer devObserver, HelperName: devHelper, Message from: test, Message: test", stringMessageOut.getMessage());
    }
}

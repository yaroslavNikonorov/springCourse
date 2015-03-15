package org.diosoft.spring.core.lesson5;

import org.diosoft.spring.core.hw4.Message;
import org.diosoft.spring.core.hw4.Observer;
import org.diosoft.spring.core.hw4.Subject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;

/**
 * Created by yar on 13.03.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/lesson5/spring-config-testfw.xml")
@TestExecutionListeners({MyCustomTestExecutionListener.class,
        ServletTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        SqlScriptsTestExecutionListener.class})
@ActiveProfiles({"qa", "dev"})
public class ObserverTest {

    @Autowired
    private Subject subject;

//    @Autowired
//    private Observer observer;

    @Before
    public void before(){
        System.out.println("Before lunched");
    }

    @Test
    public void testExecution(){
        System.out.println("Test executed");
    }

    @Test
    public void testObserver(){
        subject.notifyObservers(new Message("dsadas", "dsadsad"));
    }

}

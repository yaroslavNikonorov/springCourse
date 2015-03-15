package org.diosoft.spring.core.lesson5;

import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

/**
 * Created by yar on 13.03.15.
 */
public class MyCustomTestExecutionListener implements TestExecutionListener {
    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {
        System.out.println("BeforeTestClass");
    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
        System.out.println("PrepareTestInstance");
    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        System.out.println("BeforeTestMethod");
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        System.out.println("AfterTestMethod");
    }

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
        System.out.println("AfterTestClass");
    }
}

package org.diosoft.spring.core.lesson3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yar on 02.03.15.
 */
public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/lesson3/application-context.xml");
        context.registerShutdownHook();
//        SimpleBean simpleBean1 = (SimpleBean) context.getBean("test1");
//        System.out.println(simpleBean1.getName());
//        SimpleBean simpleBean2 = (SimpleBean) context.getBean("test2");
//        System.out.println(simpleBean2.getName());
//        SimpleBean simpleBean3 = (SimpleBean) context.getBean("test1");
//        if(simpleBean1==simpleBean3){
//            System.out.println(true);
//        }
//        simpleBean3.setName("${}");

        ActionBean actionBean = context.getBean(ActionBean.class);
        actionBean.beanNames();
        System.out.println(actionBean.getName());

    }
}

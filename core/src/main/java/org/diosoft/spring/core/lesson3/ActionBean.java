package org.diosoft.spring.core.lesson3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import java.util.List;

/**
 * Created by yar on 02.03.15.
 */
public class ActionBean {
    private List<SimpleBean> simpleBeans;
//    @Autowired
//    private Environment environment;
    @Value("${action.bean}")
    private String name;

    @Autowired
    public ActionBean(List<SimpleBean> simpleBeans, Environment environment) {
        this.simpleBeans = simpleBeans;
//        this.environment=environment;
//        this.name=environment.getProperty("action.bean");
    }

    public ActionBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void beanNames(){
        for(SimpleBean simpleBean: simpleBeans){
            System.out.println(simpleBean.getName());
        }
    }

}

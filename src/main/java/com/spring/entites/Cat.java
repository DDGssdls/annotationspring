package com.spring.entites;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Cat implements InitializingBean, DisposableBean {

    public Cat(){
        System.out.println("new cat");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat dead.... DisposableBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat born... afterPropertiesSet");
    }
}

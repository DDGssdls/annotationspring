package com.spring.entites;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Car {

    public Car(){
        System.out.println("car constructor...");
    }
    @PostConstruct //方法中不能有参数 但是能有异常
    public void init() throws RuntimeException{
        System.out.println("car init....");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("car destroy ....");
    }

}

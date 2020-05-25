package com.spring.PostProcesser;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component// 使用的时候需要也是一个组件需要加入到容器中
public class MyBeanPostProcessor implements BeanPostProcessor {
    // 初始化之前的后置处理
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+"--->postProcessBeforeInitialization--->"+bean);
        return bean;
    }
    // 初始化之后的后置处理
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+"--->postProcessAfterInitialization--->"+bean);
        return bean;
    }
}

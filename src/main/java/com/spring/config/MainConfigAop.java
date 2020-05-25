package com.spring.config;


import com.spring.calculator.LogAspect;
import com.spring.calculator.MainCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class MainConfigAop {
    // 这里的是aop使用的是运行时期动态的将一段代码切入到
    @Bean
    public MainCalculator calculator(){
        return new MainCalculator();
    }
    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }
}

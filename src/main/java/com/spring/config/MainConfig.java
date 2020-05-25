package com.spring.config;

import com.spring.conditional.MyConditional;
import com.spring.entites.*;
import com.spring.factory.MyFactoryBean;
import com.spring.selecter.MyImportSelector;
import com.spring.typefilter.MyTypeFilter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Configuration// 表明这是一个配置类
//@ComponentScan(value = "com.spring", excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Annotation.class})
//})// 配置的是注解扫描的包 一般的都是排除springmvc中的注解
//@Import({Color.class, MyImportSelector.class})
@ComponentScan(value = "com.spring"/*, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.CUSTOM ,classes = {MyTypeFilter.class})
}*/)
@PropertySource("classpath:dog.properties")
public class MainConfig {
    @Lazy
    @Bean(value = "myPerson")
    @Scope("singleton")
    @Conditional(MyConditional.class)
    public Person person(){
        return new Person("lisi", 2);
    }
    @Bean
    public MyFactoryBean factoryBean(){
        return new MyFactoryBean();
    }

//    @Bean(initMethod = "init", destroyMethod = "destroy")
//    public Car car(){
//        return new Car();
//    }

    @Bean()
    public Cat cat(){
        return new Cat();
    }
//    @Bean
//    //@Qualifier("dog")
//    public Dog dog(){
//        return new Dog();
//    }
//    @Bean
//    @Primary
//    //@Qualifier("dog2")
//    public Dog dog2(){
//        return new Dog();
//    }

}

package com.spring;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import com.spring.config.MainConfig;
import com.spring.config.MainConfigProfile;
import com.spring.entites.*;
import com.spring.factory.MyFactoryBean;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.beans.Beans;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
//@ContextConfiguration(classes = {MainConfig.class})
public class TestSpring {
    private static ClassPathXmlApplicationContext beans;
    private static AnnotationConfigApplicationContext annoBeans;

    @BeforeClass
    public static void testCreate(){
       //beans = new ClassPathXmlApplicationContext("beans.xml");
        annoBeans = new AnnotationConfigApplicationContext(MainConfig.class);
    }

    @Test
    public void test(){
//        ClassPathXmlApplicationContext beans = new ClassPathXmlApplicationContext("beans.xml");
        //Person person = beans.getBean("person", Person.class);
        Person person1 = annoBeans.getBean( Person.class);
        Person person2 = annoBeans.getBean( Person.class);
        System.out.println(person1 == person2);
//        // 获取ioc中的bean的名称
//        String[] beanNamesForType = annoBeans.getBeanNamesForType(Person.class);
//        for (String s : beanNamesForType) {
//            System.out.println(s);

    }

    @Test
    public void testBean(){
        String[] beanDefinitionNames = annoBeans.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
    @Test
    public void testGetBean(){
        // 使用这样的方式创建出来的其实是color类型的不是工厂 所以传入的类型也是 color类型不是 工厂类型
       Object myFactoryBean = annoBeans.getBean("factoryBean", Color.class);
       Object myRealFactoryBean = annoBeans.getBean("&factoryBean");
        System.out.println(myFactoryBean.getClass());
        System.out.println(myRealFactoryBean.getClass());
    }

    @Test
    public void testClose(){
        annoBeans.close();
    }
    @Test
    public void testCat(){
        Cat bean = annoBeans.getBean(Cat.class);
        System.out.println(bean);
    }
    @Test
    public void testDog(){
        Dog bean = annoBeans.getBean( Dog.class);
        System.out.println(bean);
    }

    @Test
    public void testBoss(){
        Boss bean = annoBeans.getBean(Boss.class);
        System.out.println(annoBeans.getBean(Car.class));
        System.out.println(bean);
    }

    @Test
    public void getData(){
       AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext();
       ioc.getEnvironment().setActiveProfiles("dev");
       ioc.register(MainConfigProfile.class);
       ioc.refresh();

        String[] beanNamesForType = ioc.getBeanNamesForType(ComboPooledDataSource.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
    }
}

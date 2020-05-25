package com.spring;

import com.spring.calculator.MainCalculator;
import com.spring.config.MainConfigAop;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.nio.file.Files;

public class TestIoc {
    private static AnnotationConfigApplicationContext annoIoc;
    private static FileSystemXmlApplicationContext fileIoc;
    private static ClassPathXmlApplicationContext xmlIoc;

    @BeforeClass
    public static void testInit(){
        annoIoc = new AnnotationConfigApplicationContext(MainConfigAop.class);
       // xmlIoc = new ClassPathXmlApplicationContext("classpath:beans.xml");
    }

    @Test
    public void testAop(){
        MainCalculator bean = annoIoc.getBean(MainCalculator.class);
        int div = bean.div(5, 0);
        System.out.println(div);
        annoIoc.close();
    }

    @Test
    public void testXml(){
        MainCalculator bean = xmlIoc.getBean(MainCalculator.class);
        int div = bean.div(5, 1);
        System.out.println(div);
        xmlIoc.close();

    }

}

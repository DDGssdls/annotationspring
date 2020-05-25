package com.spring;



import com.spring.tx.MyTxConfig;
import com.spring.tx.MyUserDao;
import com.spring.tx.UserService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestTx {

    private static AnnotationConfigApplicationContext ioc;
    private static ClassPathXmlApplicationContext xmlIoc;

    @BeforeClass
    public static void testBefore(){
        //ioc = new AnnotationConfigApplicationContext(MyTxConfig.class);
        xmlIoc = new ClassPathXmlApplicationContext("classpath:beans.xml");

    }

    @Test
    public void testTx(){
        MyUserDao bean = xmlIoc.getBean(MyUserDao.class);
        bean.test();

    }
}

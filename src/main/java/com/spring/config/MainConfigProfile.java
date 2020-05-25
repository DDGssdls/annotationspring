package com.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.mbean.C3P0PooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import java.beans.PropertyVetoException;
@PropertySource("classpath:dog.properties")
@Configuration
@Profile("test")
public class MainConfigProfile implements EmbeddedValueResolverAware {// 使用profile注解 激活 和 切换组件的环境

    @Value("${username}")
    private String username;
    private String password;
    private StringValueResolver resolver;



    @Bean
    @Profile("test")
    public ComboPooledDataSource c3P0PooledDataSource(@Value("${password}")String password ) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///db2019");
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }
    @Bean
    @Profile("dev")
    public ComboPooledDataSource c3P0PooledDataSource1(@Value("${password}")String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        //dataSource.setJdbcUrl("jdbc:mysql:///db2019");
        String s = resolver.resolveStringValue("${url}");
        dataSource.setJdbcUrl(s);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }
    @Bean
    @Profile("QA")
    public ComboPooledDataSource c3P0PooledDataSource2(@Value("${password}")String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///db2019");
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.resolver = resolver;
    }
}

package com.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MyUserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void test(){
        String sql = "INSERT INTO `payment`(serial) VALUES(?)";

        jdbcTemplate.update(sql, "张三");
        System.out.println("执行成功！");
       //int i = 1/0;
    }
}

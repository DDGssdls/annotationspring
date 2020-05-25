package com.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void insert(){
		String sql = "INSERT INTO `payment`(serial) VALUES(?)";

		jdbcTemplate.update(sql, "уехЩ");
		
	}

}

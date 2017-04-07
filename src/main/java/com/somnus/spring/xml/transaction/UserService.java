package com.somnus.spring.xml.transaction;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class UserService {
	
	private JdbcTemplate jdbcTemplate;
	
	private String userSql = String.format("INSERT INTO T_USER VALUES ('%s','%s','%s')", "10000", "admin", "passw0rd");
	private String logSql  = String.format("INSERT INTO T_LOG VALUES ('%s','%s')", "10000", "first log");
	
	/**
	 * A如果有事务，B就加入当前事务（方法B看到自己已经运行在 方法A的事务内部，就不再起新的事务，直接加入方法A）
	 */
	@Transactional
	public void B1() {
    	jdbcTemplate.update(logSql);
    	jdbcTemplate.update(logSql);
    	System.out.println(1/0);
    }
	
	@Transactional
    public void A1() {
    	jdbcTemplate.update(userSql);
    	jdbcTemplate.update(userSql);
    	B1();
    }
	
	/**
	 * A如果有事务，B就加入当前事务（方法B看到自己已经运行在 方法A的事务内部，就不再起新的事务，直接加入方法A）
	 */
	@Transactional
	public void B11() {
    	jdbcTemplate.update(logSql);
    	jdbcTemplate.update(logSql);
    }
	
	@Transactional
    public void A11() {
    	jdbcTemplate.update(userSql);
    	jdbcTemplate.update(userSql);
    	B11();
    	System.out.println(1/0);
    }
	
	/**
	 * A如果没有事务，B就开启一个事务(方法B运行的时候发现自己没有在事务中，它就会为自己分配一个事务)；
	 */
	@Transactional
	public void B2() {
    	jdbcTemplate.update(logSql);
    	jdbcTemplate.update(logSql);
    	System.out.println(1/0);
    }
	
    public void A2() {
    	jdbcTemplate.update(userSql);
    	jdbcTemplate.update(userSql);
    	B2();
    }
    
    /**
	 * A如果没有事务，B就开启一个事务(方法B运行的时候发现自己没有在事务中，它就会为自己分配一个事务)；
	 */
	@Transactional
	public void B22() {
    	jdbcTemplate.update(logSql);
    	jdbcTemplate.update(logSql);
    }
	
    public void A22() {
    	jdbcTemplate.update(userSql);
    	jdbcTemplate.update(userSql);
    	B22();
    	System.out.println(1/0);
    }
    

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
    
}

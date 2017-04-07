package com.somnus.spring.xml.transaction;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class UserServiceNew {
	
	private JdbcTemplate jdbcTemplate;
	
	private String userSql = String.format("INSERT INTO T_USER VALUES ('%s','%s','%s')", "10000", "admin", "passw0rd");
	private String logSql  = String.format("INSERT INTO T_LOG VALUES ('%s','%s')", "10000", "first log");
	
	/**
	 * A如果有事务，B就将当前事务挂起（方法A所在的事务就会挂起，方法B会起一个新的事务，等待方法B的事务完成以后，方法A才继续执行）。
	 * 这就是 RROPAGATION_REQUIRES_NEW，意思就是创建了一个新事务，它和原来的事务没有任何关系了。
	 * 【RROPAGATION_REQUIRES_NEW与 PROPAGATION_REQUIRED 的事务区别在于事务的回滚程度了。
	 * 因为 方法B是新起一个事务，那么就是存在两个不同的事务。如果方法B已经提交，那么 方法A失败回滚，方法B是不会回滚的。
	 * 如果方法B失败回滚，如果它抛出的异常被方法A捕获，方法A的事务仍然可能提交(主要看方法B抛出的异常是不是方法A会回滚的异常)】
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
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
	 * A如果有事务，B就将当前事务挂起（方法A所在的事务就会挂起，方法B会起一个新的事务，等待方法B的事务完成以后，方法A才继续执行）。
	 * 这就是 RROPAGATION_REQUIRES_NEW，意思就是创建了一个新事务，它和原来的事务没有任何关系了。
	 * 【RROPAGATION_REQUIRES_NEW与 PROPAGATION_REQUIRED 的事务区别在于事务的回滚程度了。
	 * 因为 方法B是新起一个事务，那么就是存在两个不同的事务。如果方法B已经提交，那么 方法A失败回滚，方法B是不会回滚的。
	 * 如果方法B失败回滚，如果它抛出的异常被方法A捕获，方法A的事务仍然可能提交(主要看方法B抛出的异常是不是方法A会回滚的异常)】
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void B1_() {
    	jdbcTemplate.update(logSql);
    	jdbcTemplate.update(logSql);
    	System.out.println(1/0);
    }
	
	@Transactional(rollbackFor=ArrayIndexOutOfBoundsException.class)
    public void A1_() {
    	jdbcTemplate.update(userSql);
    	jdbcTemplate.update(userSql);
    	B1_();
    }
	
	/**
	 * A如果有事务，B就将当前事务挂起（方法A所在的事务就会挂起，方法B会起一个新的事务，等待方法B的事务完成以后，方法A才继续执行）。
	 * 这就是 RROPAGATION_REQUIRES_NEW，意思就是创建了一个新事务，它和原来的事务没有任何关系了。
	 * 【RROPAGATION_REQUIRES_NEW与 PROPAGATION_REQUIRED 的事务区别在于事务的回滚程度了。
	 * 因为 方法B是新起一个事务，那么就是存在两个不同的事务。如果方法B已经提交，那么 方法A失败回滚，方法B是不会回滚的。
	 * 如果方法B失败回滚，如果它抛出的异常被方法A捕获，方法A的事务仍然可能提交(主要看方法B抛出的异常是不是方法A会回滚的异常)】
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
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
	@Transactional(propagation=Propagation.REQUIRES_NEW)
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
    @Transactional(propagation=Propagation.REQUIRES_NEW)
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

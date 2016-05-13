package com.somnus.transaction;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl {
	@Resource
	private JdbcTemplate jdbcTemplate;
	private String userSql = String.format("INSERT INTO T_USER VALUES ('%s','%s','%s')", 
            "10000", "admin", "passw0rd");
	private String logSql = String.format("INSERT INTO T_LOG VALUES ('%s','%s')", 
            "10000", "first log");
	
	/******************************REQUIRED**************************************/
    /**方法A有事务，方法B中的事务加到方法A中*/
    @Transactional(propagation=Propagation.REQUIRED)
    public void a12() {
    	jdbcTemplate.update(logSql);
		throw new RuntimeException("我是故意抛出的一个运行期异常");
    }
    @Transactional(propagation=Propagation.REQUIRED)
    public void b12() {
    	jdbcTemplate.update(userSql);
    	a12();
    }
    /**************************REQUIRES_NEW******************************************/
    /**方法A有事务，就将当前事务挂起*/
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public void a22() {
    	jdbcTemplate.update(logSql);
		throw new RuntimeException("我是故意抛出的一个运行期异常");
    }
    @Transactional(propagation=Propagation.REQUIRED)
    public void b22() {
    	jdbcTemplate.update(userSql);
    	a22();
    }
    /**************************NESTED******************************************/
    /**方法A有事务，就在当前事务中嵌套其他事务*/
    @Transactional(propagation=Propagation.NESTED)
    public void a32() {
    	jdbcTemplate.update(logSql);
		throw new RuntimeException("我是故意抛出的一个运行期异常");
    }
    @Transactional(propagation=Propagation.REQUIRED)
    public void b32() {
    	jdbcTemplate.update(userSql);
    	a32();
    }
    /**************************SUPPORTS******************************************/
    /**方法A有事务，就使用当前事务*/
    @Transactional(propagation=Propagation.SUPPORTS)
    public void a42() {
    	jdbcTemplate.update(logSql);
		throw new RuntimeException("我是故意抛出的一个运行期异常");
    }
    @Transactional(propagation=Propagation.REQUIRED)
    public void b42() {
    	jdbcTemplate.update(userSql);
    	a42();
    }
}

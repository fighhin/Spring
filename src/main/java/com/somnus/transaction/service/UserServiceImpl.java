package com.somnus.transaction.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.somnus.transaction.dao.LogDao;
import com.somnus.transaction.dao.UserDao;
import com.somnus.transaction.domain.Log;
import com.somnus.transaction.domain.User;

@Service
public class UserServiceImpl {
	@Resource
	private UserDao userDao;
	@Resource
	private LogDao logDao;
	
	public User getUser(int id) {
		return null;
	}
	
	/**方法A没有事务，就新建一个事务*/
	public void add(User user) {
		userDao.save(user);
	}
	
    @Transactional(propagation=Propagation.REQUIRED)
    public void add2(User user) {
        add(user);
        Log log = new Log();
        log.setMsg("a user saved!");
        logDao.save(log);
        throw new RuntimeException();
    }
    /**方法A有事务，就加入到方法B中的事务中*/
    /*@Transactional
    public void add(User user) {
        userDao.save(user);
    }
    
    @Transactional(propagation=Propagation.REQUIRED)
    public void add2(User user) {
        add(user);
        Log log = new Log();
        log.setMsg("a user saved!");
        logDao.save(log);
        throw new RuntimeException();
    }*/

}

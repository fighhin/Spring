package com.somnus.redis.dao.impl;

import org.springframework.stereotype.Repository;

import com.somnus.redis.dao.UserDao;
import com.somnus.redis.model.User;

/**  
 * @Description: TODO
 * @author Somnus
 * @date 2016年5月8日 下午9:04:28 
 * @version 1.0 
 */
@Repository(value="redisUserDaoImpl")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

}
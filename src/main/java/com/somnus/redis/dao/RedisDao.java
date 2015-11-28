package com.somnus.redis.dao;

import com.somnus.redis.model.User;

/**  
 * @Description: TODO
 * @author Somnus
 * @date 2015年11月28日 下午8:10:56 
 * @version 1.0 
 */
public interface RedisDao {
	
	public void saveUser(final User user);
	
	public User getUser(final long id);

}

package com.somnus.redis.model;

/**  
 * @Description: TODO
 * @author Somnus
 * @date 2015年11月28日 下午8:10:45 
 * @version 1.0 
 */
public class User {
	
	private long id;
	
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "id:" + id+" | "+"name:"  + name;
	}
}

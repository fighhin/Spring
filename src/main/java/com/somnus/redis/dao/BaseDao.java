package com.somnus.redis.dao;

public interface BaseDao<V> {
	
	public void save(final String key,final V value);
	
	public void save(final String key,final V value,final int expire);
	
	public V get(final String key);
	
	public void delete(final String key);

}

package com.somnus.redis.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import com.somnus.redis.dao.BaseDao;

public abstract class BaseDaoImpl<V> implements BaseDao<V> {
	
	@Autowired
	protected RedisTemplate<String, Serializable> redisTemplate;
	
	@SuppressWarnings("unchecked")
	private final RedisSerializer<V> valueSerializer = new Jackson2JsonRedisSerializer<V>((Class<V>) getEntityClass());
	
	@Override
	public void save(final String key,final V value) {
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				connection.set(redisTemplate.getStringSerializer().serialize(key),
                			   valueSerializer.serialize(value));
				return null;
			}
		});
	}
	
	public void save(final String key,final V value,final int expire){
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				connection.setEx(redisTemplate.getStringSerializer().serialize(key), 
                				 expire, valueSerializer.serialize(value));
				return null;
			}
		});
	}

	@Override
	public V get(final String key){
		return redisTemplate.execute(new RedisCallback<V>() {
			@Override
			public V doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] rawKey = redisTemplate.getStringSerializer().serialize(key);
				if (connection.exists(rawKey)) {
					byte[] value = connection.get(rawKey);
					V v = (V) valueSerializer.deserialize(value);
                    return v;
				}
				return null;
			}
		});
	}
    
	@Override  
	public void delete(final String key) {
		redisTemplate.delete(key);
	}
	
	protected Class<?> getEntityClass() {
        return this.getGenericClass(this.getClass(), 0);
    }
	
	private Class<?> getGenericClass(Class<?> clazz, int index) {
        Type genType = clazz.getGenericSuperclass();
        if (genType instanceof ParameterizedType) {
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            if ((params != null) && (params.length >= (index - 1))) {
                return (Class<?>) params[index];
            }
        }
        return null;
    }
}
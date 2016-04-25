package com.somnus.memcached;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import net.spy.memcached.MemcachedClient;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.transaction.AbstractTransactionSupportingCacheManager;

public class MemcachedCacheManager extends AbstractTransactionSupportingCacheManager{
	
	private transient Logger log = LoggerFactory.getLogger(this.getClass());
	
	private ConcurrentMap<String, Cache> cacheMap = new ConcurrentHashMap<String, Cache>();
	
    private Map<String, Integer> expireMap = new HashMap<String, Integer>();   //缓存的时间  
    
    /**memcached的客户端  */
    private MemcachedClient memcachedClient;
    
    @Override  
    protected Collection<? extends Cache> loadCaches() {
        Collection<Cache> values = cacheMap.values();
        return values;
    }  
  
    @Override  
    public Cache getCache(String name) {
        Cache cache = cacheMap.get(name);
        if (cache == null) {
            Integer expire = expireMap.get(name);
            if (expire == null) {
                expire = 0;
                expireMap.put(name, expire);
            }
            cache = new MemcachedCache(name, expire.intValue(), memcachedClient);
            cacheMap.put(name, cache);
        }
        return cache;
    }
  
    public void setMemcachedClient(MemcachedClient memcachedClient) {
        this.memcachedClient = memcachedClient;
    }  
  
    public void setConfigMap(Map<String, Integer> configMap) {
        this.expireMap = configMap;
    }
    
	
	public void put(String key, Object value, int expire) {
		if(log.isDebugEnabled()){
			log.debug("添加缓存:{} , 过期时间:{}", key, expire);
		}
		String[] nk = split(key);
		getCache(nk[0]).put(key, nk[1]);
	}

	public Object get(String key) {
		String[] nk = split(key);
		return getCache(nk[0]).get(nk[1]);
	}

	public void remove(String...keys) {
		if(keys != null && keys.length > 0){
			for (int i = 0; i < keys.length; i++) {
				if(log.isDebugEnabled()){
					log.debug("清理缓存:{}", keys[i]);
				}
				String[] nk = split(keys[i]);
				getCache(nk[0]).evict(nk[1]);
			}
		}
	}
	
	private String[] split(String key){
		if(!StringUtils.contains(key, "_")){
			
		}
		String[] nk = key.split("_");
		return nk;
	}

}

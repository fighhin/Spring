package com.somnus.mybatis.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import com.somnus.mybatis.dao.UserInfoDao;
import com.somnus.mybatis.domain.UserInfo;

@Component
public class UserInfoCache {
	@Autowired
	private UserInfoDao userinfodao;
	
	@Cacheable(value = "cache.somnus.userinfo", key = "#p0")
    public UserInfo selectByKey(int key){
        return userinfodao.selectByKey(key);
    }
}

package com.somnus.mybatis.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.mybatis.domain.UserInfo;
import com.somnus.support.mybatis.annotation.MyBatisRepository;

@MyBatisRepository
public interface UserInfoDao {
	
	UserInfo selectByKey(int id);
	
	void inserUser(UserInfo user);
	
	PageList<UserInfo> selectByParams(String param);
}

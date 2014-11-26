package com.somnus.mybatis.service;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.mybatis.domain.UserInfo;

public interface UserInfoService {
	public UserInfo selectByKey(int id);
	public UserInfo selectByKeyFromCache(int id);
	public void inserUser(UserInfo user);
	public PageList<UserInfo> selectByParams(UserInfo userinfo,Map<String,Object> map);
	public List<UserInfo> selectExceltData();
}

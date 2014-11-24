package com.somnus.mybatis.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.mybatis.dao.UserInfoDao;
import com.somnus.mybatis.domain.UserInfo;

@Component
public class UserInfoServiceImpl {
	@Resource
	private UserInfoDao userinfodao;
	
	public UserInfo selectByKey(int id){
		return userinfodao.selectByKey(id);
	}
	
	public void inserUser(UserInfo user){
		inserUser(user);
	}
	
	public PageList<UserInfo> selectByParams(String param){
		return userinfodao.selectByParams(param);
	}
}

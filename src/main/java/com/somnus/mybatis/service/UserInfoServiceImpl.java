package com.somnus.mybatis.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
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
	
	public PageList<UserInfo> selectByParams(UserInfo userinfo,Map<String,Object> map){
		//页号
		int page = (Integer)map.get("page"); 
		
		//每页数据条数
		int pageSize = (Integer)map.get("limit"); 
		
		//如果你想排序的话逗号分隔可以排序多列 
		String sortString = map.get("sortString").toString();
		
		PageBounds pageBounds = new PageBounds();
		pageBounds.setContainsTotalCount(true);
		pageBounds.setLimit(pageSize);
		pageBounds.setPage(page);
		pageBounds.setOrders(Order.formString(sortString));
		
		Map<String,Object> parammap = new HashMap<String,Object>();
		parammap.put("username", userinfo.getUsername());
		
		return userinfodao.selectByParams(parammap,pageBounds);
	}
}

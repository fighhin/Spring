package com.somnus.mybatis.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.domain.TrnTransaction;
import com.somnus.jms.JmsService;
import com.somnus.mybatis.cache.UserInfoCache;
import com.somnus.mybatis.dao.UserInfoDao;
import com.somnus.mybatis.domain.UserInfo;
import com.somnus.mybatis.service.UserInfoService;
import com.somnus.support.common.MsgCodeList;
import com.somnus.support.exceptions.BizException;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	private static Logger log = LoggerFactory.getLogger(UserInfoServiceImpl.class);
	@Autowired
	private MessageSourceAccessor msa;
	@Resource
	private UserInfoDao userinfodao;
	@Resource
	private UserInfoCache userinfocache;
	@Resource
    private JmsService      jmsService;
	
	public UserInfo selectByKey(int id){
		//7、发送jms消息
		TrnTransaction transaction = new TrnTransaction();
		transaction.setBankAccCode("10086");
        jmsService.incomeSend(transaction);
		return userinfodao.selectByKey(id);
	}
	
	public UserInfo selectByKeyFromCache(int id){
		return userinfocache.selectByKey(id);
	}
	
	public void inserUser(UserInfo user){
		inserUser(user);
	}
	
	public List<UserInfo> selectExceltData(){
		return userinfodao.selectExceltData();
	}
	
	public PageList<UserInfo> selectByParams(UserInfo userinfo,Map<String,Object> map){
		log.info("selectByParams方法被调用");
		if (userinfo == null) {
			log.error("userinfo must not be null:{}", new Object[] { userinfo });
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001, new Object[]{"用户信息"}));
		}
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

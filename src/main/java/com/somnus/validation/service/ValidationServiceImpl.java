package com.somnus.validation.service;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.somnus.validation.model.User;

@Service
@Validated//告诉MethodValidationPostProcessor此Bean需要开启方法级别验证支持   
public class ValidationServiceImpl{

	public @NotNull User guess(@Valid User u) {
		// 获取 User Model
		User user = new User("admin","123456",new Date()); // 此处应该从数据库获取
		if (!"admin".equals(u.getUsername())) {// 方便后置添加的判断（此处假设传入的用户名不为null 则返回null）
			return null;
		}
		return user;
	}
}

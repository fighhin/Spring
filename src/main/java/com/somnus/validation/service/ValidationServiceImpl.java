package com.somnus.validation.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.somnus.validation.model.User;

@Service
@Validated//告诉MethodValidationPostProcessor此Bean需要开启方法级别验证支持   
public class ValidationServiceImpl{

	public @NotNull User get(@NotNull @Min(value = 1) Integer uuid) {
		// 获取 User Model
		User user = new User("admin","123456"); // 此处应该从数据库获取
		if (uuid > 100) {// 方便后置添加的判断（此处假设传入的uuid>100 则返回null）
			return null;
		}
		return user;
	}
}

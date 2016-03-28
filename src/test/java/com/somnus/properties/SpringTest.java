package com.somnus.properties;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;

public class SpringTest extends AbstractTestSupport {
	@Test
	public void sayIp(){
		PropertiesImpl service = (PropertiesImpl)ApplicationContextHolder.getBean(PropertiesImpl.class);
		System.out.println(service.getClass());
		service.sayIp();
	}
}

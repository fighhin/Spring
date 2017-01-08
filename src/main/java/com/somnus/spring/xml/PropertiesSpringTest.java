package com.somnus.spring.xml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.somnus.ApplicationContextHolder;
import com.somnus.spring.xml.properties.PropertiesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-properties.xml")
public class PropertiesSpringTest {
	
	@Test
	public void say(){
		PropertiesService service = (PropertiesService)ApplicationContextHolder.getBean(PropertiesService.class);
		System.out.println(service.getClass());
		service.sayIp();
		service.sayVersion();
		service.sayall();
	}
}

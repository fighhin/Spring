package com.somnus.properties;

import java.util.Enumeration;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PropertiesImpl {
	
	@Value("${redis.host}")
	private String ip;
	
	@Value("#{requestinfo['version']}")
	private String version;
	
	@Resource
	private Properties requestinfo;
	
	public void sayIp(){
		System.out.println("[******IP*****]" + ip);
	}
	
	public void sayVersion(){
		System.out.println("[******version*****]" + version);
	}
	
	public void sayall(){
		Enumeration<?> en = requestinfo.propertyNames();
		while (en.hasMoreElements()){
			String key = (String) en.nextElement();
			String Property = requestinfo.getProperty(key);
			System.out.println(key  +"="+  Property);
		}
	}
}

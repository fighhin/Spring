/**
 * 
 */
package com.somnus.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @description: 
 * Copyright 2011-2016 B5M.COM. All rights reserved
 * @author:  Somnus
 * @version: 1.0
 * @createDate: 2016年3月21日 上午10:43:56 
 * Modification  History:
 * Date         Author        Version        Discription
 * -----------------------------------------------------------------------------------
 * 2016年3月21日       Somnus                               1.0            
 */
@Service
public class PropertiesImpl {
	@Value("${somnus.socket.socketIP}")
	private String ip;
	
	public void sayIp(){
		System.out.println("[******IP*****]"+ip);
	}
}

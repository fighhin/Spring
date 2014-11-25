package com.somnus.sftp;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;
import com.somnus.support.util.SftpManager;

public class SftpTest extends AbstractTestSupport {
	@Test
	public void test1(){
		SftpManager manager = (SftpManager)ApplicationContextHolder.getBean(SftpManager.class);
		try {
			manager.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.somnus.support.util.velocity;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.somnus.mybatis.domain.UserInfo;
import com.somnus.mybatis.service.UserInfoService;

@Component
public class CommonVelocity {
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private VelocityEngine velocityEngine;
	
	public void createvelocityFile(){
		List<UserInfo> list = userInfoService.selectExceltData();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		VelocityUtils.mergeTemplate(velocityEngine, "template/vm/velocity.vm" , map, output, "GBK");
		try {
			OutputStream os = new FileOutputStream("E://velocity");
			BufferedOutputStream bos = new BufferedOutputStream(os);
			bos.write(output.toByteArray());
			bos.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

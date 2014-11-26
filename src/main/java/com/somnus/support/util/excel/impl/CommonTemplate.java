package com.somnus.support.util.excel.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.somnus.mybatis.domain.UserInfo;
import com.somnus.mybatis.service.UserInfoService;

@Component
public class CommonTemplate extends AbstractReportTemplate {

	@Autowired
	private UserInfoService userInfoService;
	
	private XLSTransformer tran = new XLSTransformer();
	/**
	 * @param strartDate 日期。yyyyMMdd
	 * @param endDate 用不上
	 */
	@Override
	public Workbook exportReport(String strartDate, String endDate) {
		try {
			Map<String, List> SheetMap = new HashMap<String, List>();
			List<UserInfo> list01 = userInfoService.selectExceltData();
			List<UserInfo> list02 = userInfoService.selectExceltData();
			List<UserInfo> list03 = userInfoService.selectExceltData();
			List<UserInfo> list04 = userInfoService.selectExceltData();

			SheetMap.put("STL01", list01);
			SheetMap.put("STL02", list02);
			SheetMap.put("STL03", list03);
			SheetMap.put("STL04", list04);
			// 如果没有任何数据，就返回null
			if (list01.size() + list02.size() + list03.size() + list04.size() == 0) {
				return null;
			} else {
				String template = TEMP_PATH_XLS + "temp.xlsx";
				InputStream in = getClass().getClassLoader().getResourceAsStream(template);
				Workbook workbook = tran.transformMultipleSheetsList(in, null,null, "", SheetMap, 0);
				in.close();
				return workbook;
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

}

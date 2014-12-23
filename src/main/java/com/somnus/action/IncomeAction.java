/*
 * Copyright 2010 by IPS. Floor 3,Universal Industrial Building, 
 * Tian Yaoqiao Road 1178,Shanghai, P.R. China，200300. All rights reserved.
 *
 * This software is the confidential and proprietary information of IPS
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with IPS.
 */
package com.somnus.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.somnus.domain.TrnTransaction;
import com.somnus.support.exceptions.BizException;
import com.somnus.support.jms.AbstractJmsReceiveTemplate;

public class IncomeAction extends AbstractJmsReceiveTemplate {

	protected Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void execute(Object message) throws Exception {
		log.info("-------收单记账调用开始--------");
		log.info("接收消息：{}", message);
		if (!(message instanceof TrnTransaction)) {
            throw new BizException("报文对象不匹配！");
        }
		log.info("-------收单记账调用结束--------");
	}
}

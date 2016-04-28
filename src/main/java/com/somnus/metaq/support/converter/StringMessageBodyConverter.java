package com.somnus.metaq.support.converter;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taobao.metamorphosis.client.extension.spring.MessageBodyConverter;
import com.taobao.metamorphosis.exception.MetaClientException;

public class StringMessageBodyConverter implements MessageBodyConverter<String> {

	private final static Logger LOGGER = LoggerFactory.getLogger(StringMessageBodyConverter.class);
	
	@Override
	public byte[] toByteArray(String body) throws MetaClientException {
		if(body == null)
			return null;
		try {
			return body.getBytes("utf-8");
		} catch (Exception e) {
			if(LOGGER.isWarnEnabled()){
				LOGGER.warn("metaq消息格式格式化错误", e);
			}
		}
		return null;
	}

	@Override
	public String fromByteArray(byte[] bs) throws MetaClientException {
		try {
			return new String(bs,"utf-8");
		} catch (UnsupportedEncodingException e) {
			if(LOGGER.isWarnEnabled()){
				LOGGER.warn("metaq消息格式转换错误", e);
			}
		}
		return null;
	}
}

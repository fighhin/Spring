package com.somnus.concurrent.adapter;

import com.somnus.concurrent.holder.RequestIdentityHolder;
import com.somnus.concurrent.holder.RequestInfo;

/**
 * 多线程工作者对象抽象适配器
 */
public abstract class AbstractAdapter {

	private RequestInfo requestInfo;

	public AbstractAdapter() {
		this.requestInfo = RequestIdentityHolder.get(true);
	}

	public void supportRequestIdentity() {
		if (requestInfo != null) {
			RequestIdentityHolder.join(requestInfo);
		}
	}
	
}

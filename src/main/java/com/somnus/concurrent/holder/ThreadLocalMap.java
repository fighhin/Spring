package com.somnus.concurrent.holder;

public class ThreadLocalMap extends InheritableThreadLocal<RequestInfo> {

	@Override
	protected RequestInfo childValue(RequestInfo parentValue) {
		return RequestIdentityHolder.join(parentValue);
	}

}
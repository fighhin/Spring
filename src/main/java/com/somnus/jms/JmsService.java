/**
 * 
 */
package com.somnus.jms;

import com.somnus.domain.TrnTransaction;

/**
 * @author IH745
 * @date 2013-10-11
 * 
 */
public interface JmsService {

	/**
	 * 收单队列发送
	 * @param trnTransaction
	 */
	void incomeSend(TrnTransaction trnTransaction);
	/**
	 * 协议出款
	 * @param batchNo
	 */
	void procotolDrawSend(String batchNo);
}

package com.somnus.batchtask.model;

import org.apache.commons.lang.math.RandomUtils;

/**
 * 
 * @ClassName:     HlrBusinessEvent.java
 * @Description:   Hlr指令派发任务接口定义
 * @author         Somnus
 * @version        V1.0  
 * @Since          JDK 1.7
 * @Date           2017年3月1日 下午5:25:11
 */
public class HlrBusinessEvent implements BusinessEvent{
	/** 交换机上的指令执行成功失败标识0表示成功 1表示失败*/
	public final static int TASKSUCC = 0;
	public final static int TASKFAIL = 1;
	public final static int ELAPSETIME = 1000;
	
	@Override
	public int execute(Integer userId) {
		// 这里为了距离，随机产生1000以内的随机数
		int millis = RandomUtils.nextInt(ELAPSETIME);
		
		//简单模拟往交换机停机/复机的指令
		try{
			Thread.sleep(millis);
			String strContent = String.format(
					"线程标识[%s]用户标识:[%d]执行交换机指令工单耗时:[%d]毫秒", 
					Thread.currentThread().getName(),userId,millis);
			System.out.println(strContent);
			
			//这里为了演示直接简单根据随机数是不是偶数简单模拟交换机指令执行的结果
			return (millis % 2 ==0)? TASKSUCC : TASKFAIL;
		} catch(InterruptedException e){
			e.printStackTrace();
			return TASKFAIL;
		}
	}

}

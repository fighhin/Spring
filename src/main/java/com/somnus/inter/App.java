package com.somnus.inter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("com/somnus/inter/beans.xml");
		//获取,不用接口
		//UpperLetter changeLetter=(UpperLetter) ac.getBean("changeLette");
		//System.out.println(changeLetter.change());
		//使用接口来访问bean
		ChangeLetter changeLetter=(ChangeLetter) ac.getBean("changeLette");
		System.out.println(changeLetter.change());
	}

}

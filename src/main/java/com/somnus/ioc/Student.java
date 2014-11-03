package com.somnus.ioc;

public class Student {

	private String name;

	public Student(){
		System.out.println("student constructor invoked");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		//this.name = name;
		System.out.println("你好"+name);
	}
	public void init()
	{
		System.out.println("init method invoked");
	}
}

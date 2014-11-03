package com.somnus.constructor;

public class Employee {

	public String name;
	public int age;
	
	public Employee(String name, int age) {
		System.out.println("Employee(String name, int age) 函数被调用..");
		this.name = name;
		this.age = age;
	}
}

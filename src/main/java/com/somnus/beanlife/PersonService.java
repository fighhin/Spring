package com.somnus.beanlife;

public class PersonService {

	private String name;
	private Integer age;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		System.out.println("setName(String name) 函数");
		this.name = name;
	}
	


	//也可以通过注解的方式来配置哪个方法init-method
	public void init(){
		System.out.println("我自己的init方法");
	}
	

	//定制我们的销毁方法
	public  void destory(){
		System.out.println("释放各种资源");
	}

	
}

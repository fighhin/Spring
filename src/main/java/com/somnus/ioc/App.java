package com.somnus.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//从ApplicationContext中取bean
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/somnus/ioc/beans.xml");
		//当我们去实例化beans.xml,该文件中配置的bean被实例(该bean scope是 singleton)
		Student s01 = (Student) ac.getBean("student");
		Student s02 = (Student) ac.getBean("student");
		System.out.println(s01+" "+s02);
		
		//通过文件路径来获取
		ApplicationContext ac2 = new FileSystemXmlApplicationContext("src\\main\\java\\com\\somnus\\ioc");
		Student s1 = (Student) ac2.getBean("student");
		Student s2 =(Student) ac2.getBean("student");
		System.out.println(s1+" "+s2);
		
		
		//如果我们使用beanfactory去获取bean，当你只是实例化该容器， 那么
		//容器的bean不被实例化,只有当你去使用getBean某个bean时，才会实时的创建.
		//Spring推荐使用上面的
//		BeanFactory factory = new XmlBeanFactory(
//				new ClassPathResource("com/spring/ioc/beans.xml"));
//		factory.getBean("student");
		
	
	}

}

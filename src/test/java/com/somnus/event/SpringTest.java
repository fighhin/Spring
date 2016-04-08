package com.somnus.event;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;

public class SpringTest extends AbstractTestSupport {
	@Test
	public void speak(){
		Animal animal = (Animal)ApplicationContextHolder.getBean(Animal.class);
		System.out.println(animal.speak());
	}
	
}

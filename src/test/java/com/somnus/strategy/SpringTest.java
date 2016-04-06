package com.somnus.strategy;

import org.junit.Test;

import com.somnus.AbstractTestSupport;
import com.somnus.ApplicationContextHolder;

public class SpringTest extends AbstractTestSupport {
	
	@Test
	public void createLaudHouse(){
		PolyBaseLaudHouseHandlerAdapter adapter = (PolyBaseLaudHouseHandlerAdapter)ApplicationContextHolder.getBean(
				PolyBaseLaudHouseHandlerAdapter.class);
		IPolyBaseLaudHouseService service = adapter.get("1");
		service.createLaudHouse();
	}
	
	@Test
	public void test1(){
		B b = (B)ApplicationContextHolder.getBean(B.class);
		b.lol();
	}
}

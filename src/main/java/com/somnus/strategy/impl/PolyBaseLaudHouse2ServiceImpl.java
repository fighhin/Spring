/**
 * 
 */
package com.somnus.strategy.impl;

import org.springframework.stereotype.Service;

import com.somnus.strategy.AbstractPolyBaseLaudHouseHandler;
import com.somnus.strategy.IPolyBaseLaudHouseService;

@Service
public class PolyBaseLaudHouse2ServiceImpl  extends AbstractPolyBaseLaudHouseHandler 
				implements IPolyBaseLaudHouseService{
	public PolyBaseLaudHouse2ServiceImpl(){
		super("1");
	}
	public PolyBaseLaudHouse2ServiceImpl(String type){
		super(type);
	}
	@Override
	public void createLaudHouse() {
		System.out.println("111111111111");
	}
}

package com.somnus.strategy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractPolyBaseLaudHouseHandler {
	
	protected final Set<String> types;
	
	public AbstractPolyBaseLaudHouseHandler(String type){
		
		this.types = new HashSet<String>(Arrays.asList(type));
		
	}
	public boolean isSupport(String type){
		return types.contains(type);
	}
	
	public abstract void createLaudHouse();
}

package com.somnus.inter;

public class UpperLetter implements ChangeLetter {

	private String str;
	
	
	public String change() {
		//把小写字母->大写
		return str.toUpperCase();
	}


	public String getStr() {
		return str;
	}


	public void setStr(String str) {
		this.str = str;
	}

}

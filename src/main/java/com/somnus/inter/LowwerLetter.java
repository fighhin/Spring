package com.somnus.inter;
//把小写字母-》大写
public class LowwerLetter implements ChangeLetter {

	
	private String str;
	
	
	public String change() {
		return str.toLowerCase();
	}


	public String getStr() {
		return str;
	}


	public void setStr(String str) {
		this.str = str;
	}

}

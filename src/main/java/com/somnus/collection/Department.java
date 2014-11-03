package com.somnus.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Department {

	private String name;
	private String [] empName;//数组
	private List<Employee> empList;//list集合
	private Set<Employee> empset;//set集合
	private Map<String,Employee> empMap;//map集合
	private Properties pp;//Properties的使用

	
	public Set<Employee> getEmpset() {
		return empset;
	}
	public void setEmpset(Set<Employee> empset) {
		this.empset = empset;
	}
	public String[] getEmpName() {
		return empName;
	}
	public void setEmpName(String[] empName) {
		this.empName = empName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	public Map<String, Employee> getEmpMap() {
		return empMap;
	}
	public void setEmpMap(Map<String, Employee> empMap) {
		this.empMap = empMap;
	}
	public Properties getPp() {
		return pp;
	}
	public void setPp(Properties pp) {
		this.pp = pp;
	}

}

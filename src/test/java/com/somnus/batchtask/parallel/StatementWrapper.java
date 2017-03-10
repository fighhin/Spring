package com.somnus.batchtask.parallel;

import java.sql.Connection;
import java.sql.Statement;

/**
 * 
 * @ClassName:     StatementWrapper.java
 * @Description:   JDBC封装类
 * @author         Somnus
 * @version        V1.0  
 * @Since          JDK 1.7
 * @Date           2017年2月28日 下午5:45:27
 */
public class StatementWrapper {
	private final String sql;
	private final Statement statement;
	private final Connection con;
	
	public StatementWrapper(String sql, Statement statement, Connection con) {
		super();
		this.sql = sql;
		this.statement = statement;
		this.con = con;
	}

	public String getSql() {
		return sql;
	}

	public Statement getStatement() {
		return statement;
	}

	public Connection getCon() {
		return con;
	}
	
}

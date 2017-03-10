package com.somnus.batchtask.parallel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @ClassName:     BatchQueryLoader.java
 * @Description:   并行执行加载模块
 * @author         Somnus
 * @version        V1.0  
 * @Since          JDK 1.7
 * @Date           2017年3月1日 上午10:19:57
 */
public class BatchQueryLoader {
	
	private final Collection<StatementWrapper> statements = new ArrayList<StatementWrapper>();
	
	public void attachLoadEnv(final String sql,final Statement statement,
			final Connection con){
		statements.add(new StatementWrapper(sql,statement,con));
	}
	
	public Collection<StatementWrapper> getStatements(){
		return statements;
	}
	
	public void close() throws SQLException{

		Iterator<StatementWrapper> iter = statements.iterator();
		while(iter.hasNext()){
			iter.next().getCon().close();
		}
	
	}
	
	public List<ResultSet> executeQuery() throws SQLException{
		List<ResultSet> result;
		if(statements.size() == 1){
			StatementWrapper entity = statements.iterator().next();
			
			result = Arrays.asList(entity.getStatement().executeQuery(entity.getSql()));
			
			return result;
		}else{
			BatchQueryExecutor query = new BatchQueryExecutor();
			result = query.executeQuery(statements, new BatchQuery<StatementWrapper,ResultSet>(){

				@Override
				public ResultSet query(StatementWrapper input) throws Exception {
					return input.getStatement().executeQuery(input.getSql());
				}
			});
			
			return result;
		}
	}
}

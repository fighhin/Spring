package com.somnus.transaction.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;
import com.somnus.transaction.dao.JdbcTemplateDao;

@Component("jdbc")
public class JdbcTemplateDaoImpl implements JdbcTemplateDao {
	private JdbcTemplate jdbcTemplate;
	
	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public <T> List<T> findPageByQuery(Class<T> clazz,
			final int startIndex,  final int limit) throws Exception
	{
		List<T> list = new ArrayList<T>();;
        StringBuffer sbf = new StringBuffer("select * from ");
		String table = "t_"+clazz.getName().substring(clazz.getName().lastIndexOf(".")+1, 
				clazz.getName().length()).toLowerCase();
		sbf.append(table).append(" limit ").append((startIndex-1)*limit).append(" , ").append(limit);
		String sql = sbf.toString();
		System.out.println(sql);
        List<T> rlist = (List<T>) this.jdbcTemplate.queryForList(sql);
        Iterator<?> iterator = rlist.iterator();
        T t = null;
        while (iterator.hasNext()) {
            @SuppressWarnings("unchecked")
			Map<String,Object> map = (Map<String, Object>) iterator.next();
            t = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
    		for(int i=0;i<fields.length;i++){
    			Field field = fields[i];
    			String fieldName = field.getName();
    			String firstLetter = fieldName.substring(0,1).toUpperCase();
    			String setMethodName = "set"+firstLetter+fieldName.substring(1);
    			Method setMethod = clazz.getMethod(setMethodName, new Class[]{field.getType()});
    			setMethod.invoke(t, new Object[]{map.get(fieldName)});
    		}
            list.add(t);
        }
        return list;
	}
	
	public <T> T getPerson(final Class<T> clazz,Integer id) throws Exception {
        final T t = clazz.newInstance();
        StringBuffer sbf = new StringBuffer("select * from ");
		String table = "t_"+clazz.getName().substring(clazz.getName().lastIndexOf(".")+1, 
				clazz.getName().length()).toLowerCase();
		sbf.append(table);
		sbf.append(" where id= ?");
        jdbcTemplate.query(sbf.toString(), 
                new Object[]{id},
                new RowCallbackHandler() {
                    public void processRow(ResultSet rs) {
                    	Field[] fields = clazz.getDeclaredFields();
                		try {
							for(int i=0;i<fields.length;i++){
								Field field = fields[i];
								String fieldName = field.getName();
								String firstLetter = fieldName.substring(0,1).toUpperCase();
								String setMethodName = "set"+firstLetter+fieldName.substring(1);
								Method setMethod = clazz.getMethod(setMethodName, new Class[]{field.getType()});
								String type = field.getType().toString();
							    if (type.length() > 10) {
							        type = type.substring(16);
							    }
							    if (type.equals("double")||type.equals("Double")) {
							        setMethod.invoke(t, new Object[] { rs.getDouble(fieldName) });
							    }
							    else if (type.equals("float")||type.equals("Float")) {
							        setMethod.invoke(t, new Object[] { rs.getFloat(fieldName) });
							    }
							    else if (type.equals("int")||type.equals("Integer")) {
							        setMethod.invoke(t, new Object[] { rs.getInt(fieldName) });
							    }
							    else if (type.equals("String")) {
							        setMethod.invoke(t, new Object[] { rs.getString(fieldName) });
							    }
							    else if (type.equals("boolean")) {
							        setMethod.invoke(t, new Object[] { rs.getBoolean(fieldName)});
							    }
							}
						} catch (Exception e) {
							e.printStackTrace();
						} 
                    }
                }
        );
        return t;
    }

}

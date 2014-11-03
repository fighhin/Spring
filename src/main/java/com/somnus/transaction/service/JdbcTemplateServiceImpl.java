package com.somnus.transaction.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.somnus.transaction.dao.JdbcTemplateDao;

@Component("jdbcTemplateServiceImpl")
public class JdbcTemplateServiceImpl {
	private JdbcTemplateDao jdbcDao;
	
	@Resource(name="jdbc")
	public void setJdbcDao(JdbcTemplateDao jdbcDao) {
		this.jdbcDao = jdbcDao;
	}
	public <T> List<T> findPageByQuery(Class<T> clazz,
			final int startIndex,  final int limit) throws Exception
	{
		return jdbcDao.findPageByQuery(clazz,startIndex, limit);
	}
	public <T> T getPerson(final Class<T> clazz,Integer id) throws Exception
	{
		return jdbcDao.getPerson(clazz, id);
	}

}

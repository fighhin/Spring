package com.somnus.transaction.dao;

import java.util.List;

public interface JdbcTemplateDao {
	public <T> List<T> findPageByQuery(Class<T> clazz,
			final int startIndex,  final int limit) throws Exception;
	
	public <T> T getPerson(final Class<T> clazz,Integer id) throws Exception;
}

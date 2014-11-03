package com.somnus;

import org.hibernate.Session;
/**
 * 所谓回调函数，就是在函数定义时，只定义形式参数，
 * 不定义其具体实现，而在函数被调用时才进行函数的具体实现
 * @author acer
 *
 */
public class MyHibernateTemplate
{
	public void save(final Object o)
	{

		new MyHibernateTemplate()
				.executeWithNativeSession(new MyHibernateCallback()
				{
					public void doInHibernate(Session session)
					{
						session.save(o);

					}
				});
	}
	
	public void executeWithNativeSession(MyHibernateCallback callback)
	{
		Session session = null;
		try
		{
			session = getSession();
			session.beginTransaction();

			callback.doInHibernate(session);

			session.getTransaction().commit();
		}
		catch (Exception e)
		{
			session.getTransaction().rollback();
		}
		finally
		{
			// ...
		}
	}

	private Session getSession()
	{
		return null;
	}

}

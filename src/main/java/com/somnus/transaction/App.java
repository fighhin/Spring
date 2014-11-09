package com.somnus.transaction;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.somnus.transaction.model.Book;
import com.somnus.transaction.service.JdbcTemplateServiceImpl;

public class App {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/spring/transaction/beans.xml");
		
		/*UserServiceImpl service = (UserServiceImpl)ctx.getBean("userServiceImpl");
		System.out.println(service.getClass());
		service.add(new User());*/
		
		JdbcTemplateServiceImpl impl = (JdbcTemplateServiceImpl)ctx.getBean("jdbcTemplateServiceImpl");
		List<Book> list = impl.findPageByQuery(Book.class, 2, 10);
		for(Book data:list)
		{
			System.out.println(data.getBookauthor());
			System.out.println(data.getBookname());
			System.out.println("-----------------------");
		}
		Book b = impl.getPerson(Book.class,1);
		System.out.println(b.getBookauthor());
	}

}

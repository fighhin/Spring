package com.somnus.transaction;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.somnus.transaction.model.Book;
import com.somnus.transaction.service.ExportBigData;
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
		/**
		 * 举例 画图  一条直线  两道杠截断
		 */
		ExportBigData impl2 = (ExportBigData)ctx.getBean("bigDataToExcelImpl");
		
		OutputStream os = new FileOutputStream("config/abc.zip");
		impl2.exportToZip(new String[]{"ID","书名","作者","价格"}, os, "select * from t_book");
	}

}

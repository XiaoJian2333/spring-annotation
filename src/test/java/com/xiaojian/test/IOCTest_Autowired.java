package com.xiaojian.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import com.xiaojian.bean.Boss;
import com.xiaojian.bean.Car;
import com.xiaojian.bean.Color;
import com.xiaojian.bean.Red;
import com.xiaojian.config.MainConifgOfAutowired;
import com.xiaojian.dao.BookDao;
import com.xiaojian.service.BookService;

public class IOCTest_Autowired {
	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConifgOfAutowired.class);
		
		BookService bookService = applicationContext.getBean(BookService.class);
		System.out.println(bookService);
//		BookDao bean = applicationContext.getBean(BookDao.class);
//		System.out.println(bean);
//
//		Boss boss = applicationContext.getBean(Boss.class);
//		System.out.println(boss);
//		Car car = applicationContext.getBean(Car.class);
//		System.out.println(car);
//
//		Color color = applicationContext.getBean(Color.class);
//		System.out.println(color);
//		System.out.println(applicationContext);
		applicationContext.close();
	}

}

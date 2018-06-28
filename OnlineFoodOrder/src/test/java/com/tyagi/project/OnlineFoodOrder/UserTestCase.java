package com.tyagi.project.OnlineFoodOrder;


import java.util.List;
import javax.naming.Context;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tyagi.project.OnlineFoodOrder.dao.UserDAO;
import com.tyagi.project.OnlineFoodOrder.model.UserRegister;

public class UserTestCase {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.tyagi.project.OnlineFoodOrder");
		context.refresh();

		UserDAO userDAO = (UserDAO) context.getBean("userDAO");

		UserRegister user = new UserRegister();

		user.setAddress("Hapur");
		user.setPassword("Tyagi123");
		user.setCustomername("Deepak");

		user.setEmail("19aakash33@gmail.com");
		user.setMobile(971121);

		userDAO.insertUpdateUser(user);
		System.out.println("User Inserted");

		

	}
}

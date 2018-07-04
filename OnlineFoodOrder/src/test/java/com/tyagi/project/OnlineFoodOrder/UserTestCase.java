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

		/*UserRegister user = new UserRegister();
		user.setAddress("Hapur");
		user.setPassword("Tyagi123");
		user.setCustomername("Deepak");
		user.setEmail("19aakash33@gmail.com");
		user.setMobile(971121);
		userDAO.insertUpdateUser(user);
		System.out.println("User Inserted");*/

		// Retrieval TestCase

		/*UserRegister user1 = userDAO.getUser(1);
		System.out.println("User Name:" + user1.getUsername());
		System.out.println("User Description:" + user1.getRole());*/
		  
		// Deletion TestCase
		/*UserRegister user2 = userDAO.getUser(2);
		userDAO.deleteUser(user2);
		System.out.println("The User Deleted");*/
		  
		// Retrieving the Data

	   /*List<UserRegister> list = userDAO.getUserDetails();
		for (UserRegister user3 : list) {
			System.out.println(user3.getUsername() + ":" + user3.getPassword() + ":" + user3.getRole());
		}*/

		// Update the User
		UserRegister user4 = userDAO.getUser(1);
		user4.setRole("Admin");
		userDAO.insertUpdateUser(user4);
		System.out.println("The User Updated");
		 	
}
}
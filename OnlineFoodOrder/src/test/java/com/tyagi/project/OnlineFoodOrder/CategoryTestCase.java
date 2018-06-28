package com.tyagi.project.OnlineFoodOrder;

import java.util.List;
import javax.naming.Context;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tyagi.project.OnlineFoodOrder.dao.CategoryDAO;
import com.tyagi.project.OnlineFoodOrder.model.Category;

public class CategoryTestCase {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.tyagi.project.OnlineFoodOrder");
		context.refresh();

		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

		// insert

		Category category = new Category();




	}
}

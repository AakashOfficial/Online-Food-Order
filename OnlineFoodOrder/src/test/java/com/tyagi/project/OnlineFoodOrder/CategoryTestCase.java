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
		category.setCattype("Vegetarian");
		category.setCatname("Snacks");
		category.setCatdesc("Healthy");

		categoryDAO.insertUpdateCategory(category);
		System.out.println("Category Inserted");

		// Retrieval TestCase

		/*Category category = categoryDAO.getCategory(1);
		System.out.println("Category Name:" + category.getCatname());
		System.out.println("Category Description:" + category.getCatdesc());*/

		// Deletion TestCase

		/*Category category = categoryDAO.getCategory(2);
		categoryDAO.deleteCategory(category);
		System.out.println("The Category Deleted");*/

		// Retrieving the Data

		/*List<Category> list = categoryDAO.getCategoryDetails();
		for (Category category : list) {
			System.out.println(category.getCatid() + ":" + category.getCatname() + ":" + category.getCatdesc());
		}*/

		// Update the Category

		/*Category category = categoryDAO.getCategory(1);
		category.setCatname("Italian");
		categoryDAO.insertUpdateCategory(category);
		System.out.println("The Category Updated");*/

	}
}

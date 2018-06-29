package com.tyagi.project.OnlineFoodOrder;

import java.util.List;

import javax.naming.Context;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tyagi.project.OnlineFoodOrder.dao.FoodDAO;
import com.tyagi.project.OnlineFoodOrder.model.Food;

public class FoodTestCase {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.tyagi.project.OnlineFoodOrder");
		context.refresh();

		FoodDAO foodDAO = (FoodDAO) context.getBean("foodDAO");

		/*Food food = new Food();

		food.setFoodname("Pizza");
		food.setQuantity(3);
		food.setFooddesc("Delicious");

		foodDAO.insertUpdateFood(food);
		System.out.println("food Inserted");*/

		// Retrieval TestCase

		/*Food food = foodDAO.getFood(2);
		System.out.println("Food Name:" + food.getFoodname());
		System.out.println("Category Name:" + food.getCatname());
		System.out.println("Food Description:" + food.getFooddesc());*/

		// Deletion TestCase
		/*Food food = foodDAO.getFood(2);
		foodDAO.deleteFood(food);
		System.out.println("The Food Deleted");*/

		// Retrieving the Data

		List<Food> list = foodDAO.getFoodDetails();

		for (Food food : list) {
			System.out.println(food.getCatid() + ":" + food.getCatname() + ":" + food.getFooddesc());
		}
		 
		
		 
		 

	}
}


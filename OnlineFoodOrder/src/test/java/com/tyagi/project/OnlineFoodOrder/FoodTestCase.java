package com.tyagi.project.OnlineFoodOrder;

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

		

	}
}


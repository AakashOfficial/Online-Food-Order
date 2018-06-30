package com.tyagi.project.OnlineFoodOrder;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tyagi.project.OnlineFoodOrder.dao.CartDAO;
import com.tyagi.project.OnlineFoodOrder.model.Cart;

public class CartTestCase {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.tyagi.project.OnlineFoodOrder");
		context.refresh();
		CartDAO cartDAO = (CartDAO) context.getBean("cartDAO");
		
		// Adding Or Inserting to Cart
		
		/*Cart cart = new Cart();
		cart.setCartid(1001);
		cart.setFoodid(3);
		cart.setFoodname("Leggin");
		cart.setPrice(12000);
		cart.setQuantity(6);
		cart.setStatus("N");
		cart.setUsername("Anshika");
		cartDAO.addToCart(cart);
		System.out.println("Added To Cart");*/
		
		// Retrieve 
		
		List<Cart> list = cartDAO.getCartItems("Anshika");

		for (Cart cart2 : list) {
			System.out.println(cart2.getCartid() + ";;;");
			System.out.println(cart2.getFoodid() + ";;;");
			System.out.println(cart2.getFoodname() + ";;;");
			System.out.println(cart2.getPrice() + ";;;");
			System.out.println(cart2.getQuantity() + ";;;");
		}

	}
}

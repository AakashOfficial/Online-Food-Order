package com.dao;

import java.util.ArrayList;

import com.model.Food;
import com.model.User;

public interface FoodDAO {

	public boolean validateUser(User u);
	public String giveRole(User u);
	public boolean addUser(User u);
	public boolean removeUser(User u);
	public boolean updateUser(User u);
	public boolean addFood(Food f);
	public boolean removeFood(Food f);
	public boolean removeFoodById(Food f);
	public boolean updateFood(Food f);
	public boolean addToCart(User u,Food f);
	public boolean removeFromCart(User u,Food f);
	
}



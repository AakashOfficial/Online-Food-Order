package com.model;

import java.io.Serializable;

public class Food implements Serializable {

	private String food_name;
	private String food_category;
	private String food_price;
	private String food_type;
	private String food_desc;
	private String food_path;
	private String food_id;
	
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public String getFood_category() {
		return food_category;
	}
	public void setFood_category(String food_category) {
		this.food_category = food_category;
	}
	public String getFood_price() {
		return food_price;
	}
	public void setFood_price(String food_price) {
		this.food_price = food_price;
	}
	public String getFood_type() {
		return food_type;
	}
	public void setFood_type(String food_type) {
		this.food_type = food_type;
	}
	public String getFood_desc() {
		return food_desc;
	}
	public void setFood_desc(String food_desc) {
		this.food_desc = food_desc;
	}
	public String getFood_path() {
		return food_path;
	}
	public void setFood_path(String food_path) {
		this.food_path = food_path;
	}
	public String getFood_id() {
		return food_id;
	}
	public void setFood_id(String food_id) {
		this.food_id = food_id;
	}
	
	@Override
	public String toString() {
		return "Food [food_name=" + food_name + ", food_category=" + food_category + ", food_price=" + food_price
				+ ", food_type=" + food_type + ", food_desc=" + food_desc + ", food_path=" + food_path + ", food_id="
				+ food_id + "]";
	}
	
}

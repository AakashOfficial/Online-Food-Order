package com.model;

import java.io.Serializable;

public class User implements Serializable {
	
	private String user_id;
	private String user_id_old;
	private String password;
	private String name;
	private String address;
	private String mobile_no;
	private String email_id;
	private String role;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_id_old() {
		return user_id_old;
	}
	public void setUser_id_old(String user_id_old) {
		this.user_id_old = user_id_old;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_id_old=" + user_id_old + ", password=" + password + ", name=" + name
				+ ", address=" + address + ", mobile_no=" + mobile_no + ", email_id=" + email_id + ", role=" + role
				+ "]";
	}
}

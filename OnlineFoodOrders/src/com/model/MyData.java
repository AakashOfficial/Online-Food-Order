package com.model;

import java.io.Serializable;

public class MyData implements Serializable {

	private String user_id;
	private String password;
	private String address;
	private String mobile_no;
	private String email_id;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
	@Override
	public String toString() {
		return "MyData [user_id=" + user_id + ", password=" + password + ", address=" + address + ", mobile_no="
				+ mobile_no + ", email_id=" + email_id + "]";
	}
		
}
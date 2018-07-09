package com.model;

import java.io.Serializable;

public class MyData implements Serializable {

	private String system_id;
	private String roll_no;
	private String role;
	private String name;
	private String course;
	private String branch;
	private String section;
	private String address;
	private String email;
	private String date_of_birth;
	
	public String getSystem_id() {
		return system_id;
	}
	public void setSystem_id(String system_id) {
		this.system_id = system_id;
	}
	public String getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(String roll_no) {
		this.roll_no = roll_no;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	@Override
	public String toString() {
		return "MyData [system_id=" + system_id + ", roll_no=" + roll_no + ", role=" + role + ", name=" + name
				+ ", course=" + course + ", branch=" + branch + ", section=" + section + ", address=" + address
				+ ", email=" + email + ", date_of_birth=" + date_of_birth + "]";
	}

}

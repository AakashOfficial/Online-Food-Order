package com.tyagi.project.OnlineFoodOrder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {

	@RequestMapping("/AdminHome")
	public String showadmin() {
		return "AdminHome";
	}

	@RequestMapping("/UserHome")
	public String showuser() {
		return "UserHome";
	}

	@RequestMapping("/login")
	public String showLoginPage() {
		return "Login";
	}

	@RequestMapping("/perform_logout")
	public String showLogout() {
		return "Home";
	}

	@RequestMapping("/Home")
	public String showindex() {
		return "Home";
	}

	/*@RequestMapping("/")
	public String startup() {
		return "Home";
	}*/

	@RequestMapping("/HeaderUser")
	public String showHeaderUser() {
		return "HeaderUser";
	}
	
	@RequestMapping("/Register")
	public String showRegister() {
		return "Register";
	}
	
	@RequestMapping("/OrderComplte")
	public String showOrderComplete() {
		return "OrderComplete";
	}

}
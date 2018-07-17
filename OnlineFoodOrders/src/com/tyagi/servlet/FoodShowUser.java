package com.tyagi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showFoodUser")
public class FoodShowUser extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
		
		request.getRequestDispatcher("/FoodShowUser.jsp").forward(request, response);
		
	}

}

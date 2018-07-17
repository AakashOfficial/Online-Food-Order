package com.tyagi.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FoodDAO;
import com.dao.FoodDAOImplementation;
import com.model.Food;

@WebServlet("/showFood")
public class FoodShow extends HttpServlet {
	
	FoodDAO foodDAO = new FoodDAOImplementation();
	Food food = new Food();
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
			
		request.getRequestDispatcher("/Student.jsp").forward(request, response);
		
	}
	
}

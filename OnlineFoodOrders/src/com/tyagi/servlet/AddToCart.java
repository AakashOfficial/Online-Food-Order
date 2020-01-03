package com.tyagi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.FoodDAO;
import com.dao.FoodDAOImplementation;
import com.model.Food;
import com.model.User;

@WebServlet("/addToCart")
public class AddToCart extends HttpServlet {

	User u = new User();
	Food f = new Food();
	FoodDAO foodDAO = new FoodDAOImplementation();
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter out =res.getWriter();
		HttpSession hs = req.getSession();
		String s1 =(String)hs.getAttribute("UID");
		u.setUser_id(s1);
		f.setFood_id(req.getParameter("food_ids"));
		boolean result = foodDAO.addToCart(u, f);
		
		if(result == true) {
			System.out.println("Food Is Added To Cart");
			RequestDispatcher rd = req.getRequestDispatcher("FoodShowUser.jsp");
			rd.include(req, res);
			out.println("<script>alert('Food Is Added To Cart');</script>");
		}else {
			System.out.println("Food Is Not Added To Cart");
			RequestDispatcher rd = req.getRequestDispatcher("FoodShowUser.jsp");
			rd.include(req, res);
			out.println("<script>alert('Food Is Not Added To Cart. Please Try Again Later');</script>");
		}
	}
}

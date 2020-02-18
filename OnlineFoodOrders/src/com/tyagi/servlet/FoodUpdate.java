package com.tyagi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FoodDAO;
import com.dao.FoodDAOImplementation;
import com.model.Food;

@WebServlet("/foodUpdate")
public class FoodUpdate extends HttpServlet {
	
	Food f =new Food();
	FoodDAO foodDAO = new FoodDAOImplementation();
	
	protected void service(HttpServletResponse res,HttpServletRequest req) throws ServletException,IOException {
		PrintWriter out = res.getWriter() ;
		
		f.setFood_id(req.getParameter("food_id"));
		f.setFood_name(req.getParameter("food_name"));
		f.setFood_category(req.getParameter("food_category"));
		f.setFood_price(req.getParameter("food_price"));
		f.setFood_type(req.getParameter("food_type"));
		f.setFood_desc(req.getParameter("food_desc"));
		f.setFood_path(req.getParameter("path"));
		
		boolean result = foodDAO.updateFood(f);
		
		if(result == true) {
			System.out.println("Food Is Updated");
			RequestDispatcher rd = req.getRequestDispatcher("FoodUpdate.jsp");
			rd.include(req, res);
			out.println("<script>alert('Food Is Updated');</script>");
		}else {
			System.out.println("Food Not Updated");
			RequestDispatcher rd = req.getRequestDispatcher("FoodUpdate.jsp");
			rd.include(req, res);
			out.print("<script>alert('Food Not Updated.Please Enter Correct Food Id and Try Again');</script>");
		}
	}
}

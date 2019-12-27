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

@WebServlet("/removeFood")
public class FoodRemove extends HttpServlet{

	Food f = new Food();
	FoodDAO foodDAO = new FoodDAOImplementation();
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter out = res.getWriter();
		String check = req.getParameter("secretInput");
		if(check.equals("notID")) {
			f.setFood_name(req.getParameter("food_name"));
			f.setFood_category(req.getParameter("food_category"));
			f.setFood_type(req.getParameter("food_type"));
			
			boolean result = foodDAO.removeFood(f);
			
			if(result == true) {
				System.out.println("Food Is Removed From Database");
				RequestDispatcher rd = req.getRequestDispatcher("FoodRemove.jsp");
				rd.include(req, res);
				out.print("<script>alert('Food Is Removed From Database.');</script>");
			}else {
				System.out.println("Food Is Not Removed From Database.Please Try Again Later.\n Maybe Tis Food Is Not Exist In Database");
				RequestDispatcher rd = req.getRequestDispatcher("FoodRemove.jsp");
				rd.include(req, res);
				out.print("<script>alert('Food Is Not Removed.Please Try Again Later.');</script>");
			}
		}else {
			f.setFood_id(req.getParameter("food_id"));
			
			boolean result = foodDAO.removeFoodById(f);
			
			if(result == true) {
				System.out.println("Food Is Deleted Using ID");
				RequestDispatcher rd = req.getRequestDispatcher("FoodRemove.jsp");
				rd.include(req, res);
				out.print("<script>alert('Food Is Removed From Database Using Food ID.');</script>");				
			}else {
				System.out.println("Food Is Not Removed From Database. May be This Food Is Not Present In Database.");
				RequestDispatcher rd = req.getRequestDispatcher("FoodRemove.jsp");
				rd.include(req, res);
				out.print("<script>alert('Food is not Removed From Database. Please Try Again Later. May be This Food Is Not Present In Database.');</script>");
			}
		}
		
	}
}


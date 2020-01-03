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
import javax.sql.rowset.serial.SerialException;

import com.dao.FoodDAO;
import com.dao.FoodDAOImplementation;
import com.model.Food;
import com.model.User;

@WebServlet("/cartConfirmOrRemove")
public class CartConfirmOrRemove extends HttpServlet {

	Food f = new Food();
	User u = new User();
	FoodDAO foodDAO = new FoodDAOImplementation();
	
	protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		PrintWriter out = res.getWriter();
		HttpSession hs = req.getSession();
		String s1 =(String)hs.getAttribute("UID");
		u.setUser_id(s1);
		f.setFood_id(req.getParameter("food_ids"));
		//System.out.println(s1);
		String verify = req.getParameter("submitbtn");
		if(verify.equals("Remove From Cart")) {
			boolean result = foodDAO.removeFromCart(u, f);
			if(result == true) {
				System.out.println("Food Is Removed From Cart");
				RequestDispatcher rd = req.getRequestDispatcher("CartShow.jsp");
				rd.include(req, res);
				out.println("<script>alert('Food Is Removed From Cart');</script>");
			}else {
				RequestDispatcher rd = req.getRequestDispatcher("CartShow.jsp");
				rd.include(req, res);
				out.println("<script>alert('Food Is Not Removed From Cart');</script>");
			}
		}else {
			
		}
	}
}

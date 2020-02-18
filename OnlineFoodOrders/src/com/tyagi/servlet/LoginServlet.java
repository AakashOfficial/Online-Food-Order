package com.tyagi.servlet;

import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.FoodDAO;
import com.dao.FoodDAOImplementation;
import com.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	Connection con = null;
	User u = new User();

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out = res.getWriter();
		u.setUser_id(req.getParameter("user_id"));
		u.setPassword(req.getParameter("password"));
		FoodDAO myDAO = new FoodDAOImplementation();
		boolean result = myDAO.validateUser(u);
		String resultRole = myDAO.giveRole(u);
		if (result == true) {
			HttpSession hs = req.getSession();
			hs.setAttribute("UID", u.getUser_id());
			
			System.out.println("Checking Id and Password");
			if (resultRole.equals("User")) {
				RequestDispatcher rd = req.getRequestDispatcher("HomeUser.jsp");
				rd.forward(req, res);
				System.out.print("User Sucessfully logged in");
				System.out.println("User Name is : " + u.getName());
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("HomeAdmin.jsp");
				rd.forward(req, res);
				System.out.println("Admin Sucessfully logged in");
				System.out.println("User Name is : " + u.getName());
			}

		} else {
			RequestDispatcher rd = req.getRequestDispatcher("LoginFailure.jsp");
			rd.include(req, res);
			out.print("Wrong password");
		}
	}
}

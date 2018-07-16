package com.tyagi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.MyConnection;
import com.dao.FoodDAO;
import com.dao.FoodDAOImplementation;
import com.model.User;

@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet {

	User u = new User();

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("In \" updateUser \" Servlet");
		PrintWriter out = res.getWriter();
		HttpSession hs = req.getSession();
		String s1 =(String)hs.getAttribute("UID");
		System.out.println("User Logged In " + s1);
		
		u.setUser_id_old((String)hs.getAttribute("UID"));
		u.setUser_id(req.getParameter("user_id"));
		u.setPassword(req.getParameter("password"));
		u.setEmail_id(req.getParameter("email_id"));
		u.setName(req.getParameter("name"));
		u.setMobile_no(req.getParameter("mobile_no"));
		u.setAddress(req.getParameter("address"));
		u.setRole("User");

		FoodDAO foodDAO = new FoodDAOImplementation();
		boolean result = foodDAO.updateUser(u);

		if (result == true) {
			System.out.println("User is Updated with User ID : " + u.getUser_id() + " and User Name " + u.getName());
			RequestDispatcher rd = req.getRequestDispatcher("UpdateUser.jsp");
			rd.include(req, res);
			out.print("<script type='text/javascript'>alert('User Is Updated');</script>");
		} else {
			System.out.println("User Not Found");
			RequestDispatcher rd = req.getRequestDispatcher("UpdateUser.jsp");
			rd.include(req, res);
			out.print("<script type='text/javascript'>alert('User Is Not Updated');</script>");
		}
	}
}
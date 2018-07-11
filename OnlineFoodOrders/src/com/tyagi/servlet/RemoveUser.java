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

import com.connection.MyConnection;
import com.dao.FoodDAO;
import com.dao.FoodDAOImplementation;
import com.model.User;

@WebServlet("/removeUser")
public class RemoveUser extends HttpServlet {

	User u = new User();
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter out = res.getWriter();
		u.setUser_id(req.getParameter("id"));
		
		FoodDAO foodDAO = new FoodDAOImplementation();
		boolean result = foodDAO.removeUser(u);
		
		if(result == true) {
			System.out.println("User Is Deleted with User ID : " + u.getUser_id());
			RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
			rd.include(req, res);
			out.print("<script type='text/javascript'>alert('User Is Deleted');</script>");
		}else {
			System.out.println("User Not Deleted");
			RequestDispatcher rd = req.getRequestDispatcher("RemoveUser.jsp");
			rd.include(req, res);
			out.print("<script type='text/javascript'>alert('User Not Deleted. Please Try Again');</script>");
		}
	}
}
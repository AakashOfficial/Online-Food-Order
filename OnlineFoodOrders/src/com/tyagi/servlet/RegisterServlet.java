package com.tyagi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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

@WebServlet("/registerUser")
public class RegisterServlet  extends HttpServlet {

  Connection con=null;
  User u = new User();
  
  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
	  res.setContentType("text/html");
	  PrintWriter out=res.getWriter();
	  u.setUser_id(req.getParameter("user_id"));
	  u.setPassword(req.getParameter("password"));
	  u.setName(req.getParameter("name"));
	  u.setAddress(req.getParameter("address"));
	  u.setMobile_no(req.getParameter("mobile_no"));
	  u.setEmail_id(req.getParameter("email_id"));
	  u.setRole("User");
	  
	  FoodDAO foodDAO = new FoodDAOImplementation();
	  boolean result =foodDAO.addUser(u);
	  if(result == true) {
				System.out.println("User Is Registered with User ID : " + u.getUser_id() + "  and Username is : " + u.getName());
				RequestDispatcher rd =req.getRequestDispatcher("RegisterUser.jsp");
				rd.include(req, res);
				out.print("<a href='Login.jsp'>User Successfully Registered. Please Login Here</a>");
			}else {
				RequestDispatcher rd =req.getRequestDispatcher("RegisterUser.jsp");
				rd.include(req, res);
				out.print("User Not Registered Successfully. Please Try Again");
			}
	  out.close();
	}
}

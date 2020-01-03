package com.servlet;

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

//@WebServlet("/registerAdmin")
public class RegisterAdmin extends HttpServlet {

	Statement stmt;
	Connection con = null;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String userid = req.getParameter("user_id");
		String password = req.getParameter("password");
		String role = "Admin";
		try {
			con = MyConnection.getCon();
			System.out.println("Connection Created");
			Statement stmt = con.createStatement();			
			int j = stmt.executeUpdate("insert into verification values('" + userid + "','" + password + "','" + role + "')");
			if (j >= 1) {
				System.out.println("User Is Registered with User ID : " + userid + "  and Role is : " + role);
				RequestDispatcher rd = req.getRequestDispatcher("RegisterAdminUser.jsp");
				rd.include(req, res);
				out.print("<a href='Login.jsp'>User Successfully Registered. Please Login Here</a>");
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("RegisterAdminUser.jsp");
				rd.include(req, res);
				out.print("User Not Registered Successfully. Please Try Again");
			}
			MyConnection.CloseT(con, stmt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

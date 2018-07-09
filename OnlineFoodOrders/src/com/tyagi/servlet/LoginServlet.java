package com.tyagi.servlet;

import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.MyConnection;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	Connection con = null;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("user_id");
		String pass = req.getParameter("password");
		PrintWriter out = res.getWriter();
		try {

			con = MyConnection.getCon();
			System.out.println("Connection Created");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from verification where user_id='"+name+"'and password='"+pass+"'");
			System.out.println("Data Retrived");
			String dname = "";
			String dpass = "";
			String drole = "";
			while (rs.next()) {
				dname = rs.getString(1);
				dpass = rs.getString(2);
				drole = rs.getString(3);

				System.out.println("Correct");

				if (dname.equals(name) && dpass.equals(pass)) {
					System.out.println("Checking Id and Password");
					if (drole.equals("user") || drole.equals("User")) {
						RequestDispatcher rd = req.getRequestDispatcher("HomeUser.jsp");
						rd.forward(req, res);
						System.out.print("User Sucessfully logged in");
						System.out.println("User Name is : " + dname);
					} else {
						RequestDispatcher rd = req.getRequestDispatcher("HomeAdmin.jsp");
						rd.forward(req, res);
						System.out.println("Admin Sucessfully logged in");
						System.out.println("User Name is : " + dname);
					}

				} else {
					RequestDispatcher rd = req.getRequestDispatcher("LoginFailure.jsp");
					rd.include(req, res);
					out.print("Wrong password");
				}
			}
			MyConnection.Close(con, rs, stmt);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

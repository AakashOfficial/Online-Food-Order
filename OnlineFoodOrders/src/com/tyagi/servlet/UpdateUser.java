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

@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet{
	
	Connection con = null;
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter out = res.getWriter();
		String user_id_old = req.getParameter("user_id_old");
		String user_id_input = req.getParameter("user_id");
		String password_input = req.getParameter("password");
		String email_input = req.getParameter("email_id");		
		String name_input = req.getParameter("name");
		String mobile_no_input = req.getParameter("mobile_no");
		String address_input = req.getParameter("address");
		
		System.out.println("In \" updateUser \" Servlet");
		String user_id_output, password_output, name_output, email_output, mobile_no_output,address_output,role_output="";
		try {
             System.out.println("In Try Block");
			con = MyConnection.getCon();
			System.out.println("Connection Created");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user where user_id = '" + user_id_old + "' ");
			while (rs.next()) {
				user_id_output = rs.getString(1);
				password_output = rs.getString(2);
				name_output = rs.getString(3);
				address_output = rs.getString(4);
				mobile_no_output = rs.getString(5);
				email_output = rs.getString(6);
				role_output = rs.getString(7);

				if (user_id_input.length() > 0) {
					System.out.println("User ID Is Entered by User");
				} else {
					user_id_input = user_id_output;
				}
				
				if (password_input.length() > 0) {
					System.out.println("Password Is Entered by User");
				} else {
					password_input = password_output;
				}
				
				if (name_input.length() > 0) {
					System.out.println("Name Is Entered by User");
				} else {
					name_input = name_output;
				}

				if (address_input.length() > 0) {
					System.out.println("Address Is Entered By User");
				} else {
					address_input = address_output;
				}

				if (mobile_no_input.length() > 0) {
					System.out.println("Mobile No Is Entered By User");
				} else {
					mobile_no_input = mobile_no_output;
				}
				
				if (email_input.length() > 0) {
					System.out.println("Email Is Entered By User");
				} else {
					email_input = email_output;
				}

			}
						
			String updateQuery1 = "update user set user_id = ('"+ user_id_input +"'),password = ('"+password_input+"'),name = ('"+name_input+"'), address = ('"+ address_input +"'),mobile_no = ('"+ mobile_no_input +"'),email_id = ('" +email_input+ "'),role = ('"+ role_output +"') where user_id=('"+ user_id_old +"')";
			String updateQuery2 = "update verification set user_id = ('"+user_id_input+"'),password = ('"+password_input+"'),role = ('"+role_output+"') where user_id = ('"+user_id_old+"')";
			
			Statement stmt2=con.createStatement();
			Statement stmt3=con.createStatement();
			int i=stmt2.executeUpdate(updateQuery1);			
			int j=stmt3.executeUpdate(updateQuery2);
			if (i > 0 && j > 0) {
				System.out.println("User is Updated with User ID : " + user_id_input + " and User Name " + name_input);
				RequestDispatcher rd = req.getRequestDispatcher("UpdateUser.jsp");
				rd.include(req, res);
				out.print("<script type='text/javascript'>alert('User Is Updated');</script>");
			}
			else {
			     
				System.out.println("User Not Found");
				RequestDispatcher rd = req.getRequestDispatcher("UpdateUser.jsp");
				rd.include(req, res);
				out.print("<script type='text/javascript'>alert('User Is Not Updated');</script>");
			}
			
			stmt.close();
			stmt2.close();	
			stmt3.close();
			con.close();
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
package com.servlet;

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

//@WebServlet("/removeUser")
public class RemoveUser extends HttpServlet {

    Connection con = null;
    Statement stmt,stmt2,stmt3,stmt4;
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter out = res.getWriter();
		String user_id = req.getParameter("id");
		String user_id_output,role;
		try {
            System.out.println("In Try Block");
			con = MyConnection.getCon();
			System.out.println("Connection Created");
			
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from verification where user_id = '" + user_id + "' ");
			System.out.println("Checking User In Database");
			while (rs.next()) {
				user_id_output = rs.getString(1);
				role = rs.getString(3);
				
				if( user_id_output.equals(user_id)  && role.equals("User")   ){
					stmt2 = con.createStatement();
					int i = stmt2.executeUpdate("delete from user where user_id = '"+user_id+"' ");
					stmt3 = con.createStatement();
					int j = stmt3.executeUpdate("delete from verification where user_id = '"+user_id+"' ");
					
					if(i > 0 && j > 0) {
						
						System.out.println("User Is Deleted with User ID : " + user_id);
						RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
						rd.include(req, res);
						out.print("<script type='text/javascript'>alert('User Is Deleted');</script>");
					}else {
						System.out.println("User Not Deleted");
						RequestDispatcher rd = req.getRequestDispatcher("RemoveUser.jsp");
						rd.include(req, res);
						out.print("<script type='text/javascript'>alert('User Not Deleted. Please Try Again');</script>");
					}
					stmt2.close();
					stmt3.close();
				}else if(user_id_output.equals(user_id) && role.equals("Admin")) {
					stmt4 = con.createStatement();
					int k = stmt4.executeUpdate("delete from verification where user_id = '"+user_id+"' ");
					
					if(k > 0) {
						System.out.println("User Is Deleted with User ID : " + user_id);
						RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
						rd.include(req, res);
						out.print("<script type='text/javascript'>alert('User Is Deleted');</script>");
					}else {
						System.out.println("User Not Deleted");
						RequestDispatcher rd = req.getRequestDispatcher("RemoveUser.jsp");
						rd.include(req, res);
						out.print("<script type='text/javascript'>alert('User Not Deleted. Please Try Again');</script>");
					}
					stmt4.close();
				}else {
					
				}
			}
				stmt.close();				
				con.close();
				rs.close();				
			}catch(Exception e) {
				e.printStackTrace();		
			}		
	}
}


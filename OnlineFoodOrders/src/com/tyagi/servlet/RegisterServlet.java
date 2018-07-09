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
import com.model.MyData;

@WebServlet("/registerUser")
public class RegisterServlet  extends HttpServlet {

	Connection con=null;
 MyData m = new MyData();
 
  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
	  res.setContentType("text/html");
	  PrintWriter out=res.getWriter();

	  String userid = req.getParameter("user_id");
	  String password = req.getParameter("password");
	  String name = req.getParameter("name");
	  String address = req.getParameter("address");
	  String mobile_no = req.getParameter("mobile_no");
	  String email = req.getParameter("email_id");
	  String role = "User";
		try {

			con = MyConnection.getCon();
			System.out.println("Connection Created");

			Statement stmt = con.createStatement();
			Statement stmt2 = con.createStatement();
			int i = stmt.executeUpdate("insert into user values('"+userid+"','"+password+"','"+name+"','"+address+"','"+mobile_no+"','"+email+"','"+role+"')");
			int j = stmt2.executeUpdate("insert into verification values('"+userid+"','"+password+"','"+role+"')");
			if(i>=1 && j>=1) {
				System.out.println("User Is Registered with User ID : " + userid + "  and Username is : " + name);
				RequestDispatcher rd =req.getRequestDispatcher("RegisterUser.jsp");
				rd.include(req, res);
				out.print("<a href='Login.jsp'>User Successfully Registered. Please Login Here</a>");
			}else {
				RequestDispatcher rd =req.getRequestDispatcher("RegisterUser.jsp");
				rd.include(req, res);
				out.print("User Not Registered Successfully. Please Try Again");
			}
			
			MyConnection.CloseT(con, stmt);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
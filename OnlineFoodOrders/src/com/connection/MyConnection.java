package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyConnection {
	 private static String h2_driverName="org.h2.Driver";
	 private static String h2_dbUrl="jdbc:h2:tcp://localhost/~/OnlineFoodOrderServlet";
	 private static String h2_userName="sa";
	 private static String h2_dbPass="test";
	
	private static String mysql_driverName ="com.mysql.jdbc.Driver";
	private static String mysql_dbUrl = "jdbc:mysql://localhost:3306/online_food_order";
	private static String mysql_userName ="root";
	private static String mysql_dbPass ="";
 
 	public static Connection getH2Con()throws Exception{
		 Class.forName(h2_driverName);
		 Connection con = DriverManager.getConnection(h2_dbUrl,h2_userName,h2_dbPass);
		 if(con==null){
			 throw new Exception("Connection is not created");
		 }
		 return con;
 	}
 
	 public static Connection getCon()throws Exception{
		 Class.forName(mysql_driverName);
		 Connection con = DriverManager.getConnection(mysql_dbUrl,mysql_userName,mysql_dbPass);
		 return con;
	 }
 
 	public static void Close(Connection con,ResultSet rs,Statement stmt) {
		try{
			
			if(con!=null)
				con.close();
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
 
 	public static void CloseT(Connection con,Statement stmt) {
		try{
			if(con!=null)
				con.close();
			if(stmt!=null)
				stmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

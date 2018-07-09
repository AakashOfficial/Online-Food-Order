package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyConnection {
 private static String driverName="org.h2.Driver";
 private static String dbUrl="jdbc:h2:tcp://localhost/~/StudentInformation";
 private static String userName="sa";
 private static String dbPass="test";
 
 public static Connection getCon()throws Exception{
	 Class.forName(driverName);
	 Connection con = DriverManager.getConnection(dbUrl,userName,dbPass);
	 if(con==null){
		 throw new Exception("Connection is not created");
	 }
	 return con;
 }
 
 public static void Close(Connection con,ResultSet rs,Statement stmt)
	{
		try{
			
			if(con!=null)
				con.close();
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

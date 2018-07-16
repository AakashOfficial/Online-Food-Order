package com.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.connection.MyConnection;
import com.model.Food;
import com.model.User;

public class FoodDAOImplementation implements FoodDAO {

	private static Connection con;
	static {
		try {
			con = MyConnection.getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Statement stmt, stmt2, stmt3, stmt4;
	ResultSet rs;
	   
	@Override
	public boolean validateUser(User u) {
		
		try {
		String validateQuery = "select * from verification where user_id=('"+u.getUser_id()+"')and password=('"+u.getPassword()+"')";	
	    stmt = con.createStatement();
		rs = stmt.executeQuery(validateQuery);
		System.out.println("Data Retrived");
		String dname = "";
		String dpass = "";
		while (rs.next()) {
			dname = rs.getString(1);
			dpass = rs.getString(2);

			System.out.println("Correct");
			if (dname.equals(u.getUser_id()) && dpass.equals(u.getPassword())) {
				
				return true;
			}
		}
		stmt.close();
		rs.close();
		con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	


}
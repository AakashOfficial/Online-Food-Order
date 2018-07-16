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
	
	@Override
	public String giveRole(User u) {
		try {
			String roleQuery = "select * from verification where user_id=('" + u.getUser_id() + "')and password=('"	+ u.getPassword() + "')";
		    stmt = con.createStatement();
			rs = stmt.executeQuery(roleQuery);
			System.out.println("Data Retrived");
			String drole = "";
			while (rs.next()) {
				drole = rs.getString(3);
				
				System.out.println("Correct");
				if (drole.equals("User")) {
					return drole;
				}else {
					return drole;
				}
			}
			stmt.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public boolean addUser(User u) {
		String userQuery = "insert into user values('"+u.getUser_id()+"','"+u.getPassword()+"','"+u.getName()+"','"+u.getAddress()+"','"+u.getMobile_no()+"','"+u.getEmail_id()+"','"+u.getRole()+"')";
		String verificationQuery = "insert into verification values('"+u.getUser_id()+"','"+u.getPassword()+"','"+u.getRole()+"')";
		try {
			stmt = con.createStatement();
			stmt2 = con.createStatement();
			int i = stmt.executeUpdate(userQuery);
			int j = stmt2.executeUpdate(verificationQuery);
			if(i>=1 && j>=1) {
				return true;
			}
			stmt.close();
			stmt2.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	

}
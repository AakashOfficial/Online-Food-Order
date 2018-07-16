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

	@Override
	public boolean removeUser(User u) {
		String showQuery = "select * from verification where user_id = '"+u.getUser_id()+"'";
		String removeQuery = "delete from user where user_id = '"+u.getUser_id()+"'";
		String removeQuery2 = "delete from verification where user_id = '"+u.getUser_id()+"' ";
		String role;
		try {
			stmt = con.createStatement();
			stmt2 = con.createStatement();
			stmt3 = con.createStatement();
			stmt4 = con.createStatement();
			
			rs = stmt.executeQuery(showQuery);
			System.out.println("Checking User From Database");
			while(rs.next()) {
				role = rs.getString(3);
				
				if(role.equals("User")) {
					
					int i = stmt2.executeUpdate(removeQuery);
					int j = stmt3.executeUpdate(removeQuery2);
					if(i == 1 && j == 1) {
						return true;
					}
				}else {
					int k = stmt4.executeUpdate(removeQuery2);
					if(k == 1) {
						return true;
					}
				}
			}
			
			stmt.close();
			stmt2.close();
			stmt3.close();
			stmt4.close();
			rs.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateUser(User u) {
		System.out.println("In \" updateUser \" Servlet");
		String user_id_output, password_output, name_output, email_output, mobile_no_output,address_output, role_output;
		try {
		    stmt = con.createStatement();
		    stmt2 = con.createStatement();
			stmt3 = con.createStatement();
		    rs = stmt.executeQuery("select * from user where user_id = '" + u.getUser_id_old() + "' ");
		    while (rs.next()) {
		    	user_id_output = rs.getString(1);
				password_output = rs.getString(2);
				name_output = rs.getString(3);
				address_output = rs.getString(4);
				mobile_no_output = rs.getString(5);
				email_output = rs.getString(6);
				role_output = rs.getString(7);
				
				if (u.getUser_id().length() > 0) {
					System.out.println("User ID Is Entered by User");
				} else {
					u.setUser_id(user_id_output);
				}
				
				if (u.getPassword().length() > 0) {
					System.out.println("Password Is Entered by User");
				} else {
					u.setPassword(password_output);
				}
				
				if (u.getName().length() > 0) {
					System.out.println("Name Is Entered by User");
				} else {
					u.setName(name_output);
				}

				if (u.getAddress().length() > 0) {
					System.out.println("Address Is Entered By User");
				} else {
					u.setAddress(address_output);
				}

				if (u.getMobile_no().length() > 0) {
					System.out.println("Mobile No Is Entered By User");
				} else {
					u.setMobile_no(mobile_no_output);
				}
				
				if (u.getEmail_id().length() > 0) {
					System.out.println("Email Is Entered By User");
				} else {
					u.setEmail_id(email_output);
				}
				
				String updateQuery1 = "update user set user_id = ('"+ u.getUser_id() +"'),password = ('"+u.getPassword()+"'),name = ('"+u.getName()+"'), address = ('"+ u.getAddress() +"'),mobile_no = ('"+ u.getMobile_no() +"'),email_id = ('" +u.getEmail_id()+ "'),role = ('"+ u.getRole() +"') where user_id=('"+ u.getUser_id_old() +"')";
				String updateQuery2 = "update verification set user_id = ('"+u.getUser_id()+"'),password = ('"+u.getPassword()+"'),role = ('"+u.getRole()+"') where user_id = ('"+u.getUser_id_old()+"')";
				
				
				int i=stmt2.executeUpdate(updateQuery1);			
				int j=stmt3.executeUpdate(updateQuery2);
				
				if (i > 0 && j > 0) {
					return true;
				}
		    }
			System.out.println("User Not Found with User ID : " + u.getUser_id_old());
			stmt.close();
			stmt2.close();
			stmt3.close();
			rs.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	
}
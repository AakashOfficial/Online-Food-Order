package com.tyagi.servlet;

import java.io.*;
import java.sql.*;
import java.util.zip.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.MyConnection;

@WebServlet("/foodAdd")
public class FoodAdd extends HttpServlet {

	Connection con = null;
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out = res.getWriter();
		
		String saveFile = "";
		String contentType = req.getContentType();
		if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) {
			DataInputStream in = new DataInputStream(req.getInputStream());
			int formDataLength = req.getContentLength();
			byte dataBytes[] = new byte[formDataLength];
			int byteRead = 0;
			int totalBytesRead = 0;
			while (totalBytesRead < formDataLength) {
				byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
				totalBytesRead += byteRead;
			}
			String file = new String(dataBytes);
			saveFile = file.substring(file.indexOf("filename=\"") + 10);
			saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
			saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1, saveFile.indexOf("\""));
			int lastIndex = contentType.lastIndexOf("=");
			String boundary = contentType.substring(lastIndex + 1, contentType.length());
			int pos;
			pos = file.indexOf("filename=\"");
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;
			int boundaryLocation = file.indexOf(boundary, pos) - 4;
			int startPos = ((file.substring(0, pos)).getBytes()).length;
			int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
			File ff = new File("E:\\My Project\\OnlineFoodOrders\\WebContent\\FoodImage/" + saveFile);
			System.out.println("Image Uploaded");
			FileOutputStream fileOut = new FileOutputStream(ff);
			fileOut.write(dataBytes, startPos, (endPos - startPos));
			fileOut.flush();
			fileOut.close();
			
			try {

				con = MyConnection.getCon();
				System.out.println("Connection Created");

				String fname = req.getParameter("food_name");
				String fcategory = req.getParameter("food_category");
				String fprice = req.getParameter("food_price");
				String fpath = ff.getPath();
				
				Statement stmt = con.createStatement();
				int i=stmt.executeUpdate("insert into food(food_name,food_category,food_price,FOOD_IMAGE_PATH) values('"+fname+"','"+fcategory+"','"+fprice+"','"+fpath+"')");
				Statement stmt2 = con.createStatement();
				int j=stmt2.executeUpdate("update food set food_name = '"+fname+"',food_category = '"+fcategory+"',food_price = '"+fprice+"'where food_image_path = '"+fpath+"' ");
				if(i > 0 && j > 0) {
					System.out.println("Food Is Entered");
					RequestDispatcher rd =req.getRequestDispatcher("FoodAdd.jsp");
					rd.include(req, res);
				}else {
					System.out.println("Food Not Inserted");
					RequestDispatcher rd =req.getRequestDispatcher("FoodAdd.jsp");
					rd.include(req, res);
				}	
				con.close();
				stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
				}
			}
	}
}
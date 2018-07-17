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
import com.dao.FoodDAO;
import com.dao.FoodDAOImplementation;
import com.model.Food;

@WebServlet("/foodAdd")
public class FoodAdd extends HttpServlet {

	Food f = new Food();

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out = res.getWriter();
		f.setFood_name(req.getParameter("food_name"));
		f.setFood_category(req.getParameter("food_category"));
		f.setFood_price(req.getParameter("food_price"));
		f.setFood_type(req.getParameter("food_type"));
		f.setFood_desc(req.getParameter("food_desc"));
		f.setFood_path(req.getParameter("path"));
		f.setFood_id(req.getParameter("food_id"));
		/*String fpath = req.getParameter("file");
		f.setFood_path(fpath);*/

		FoodDAO foodDAO = new FoodDAOImplementation();
		boolean result = foodDAO.addFood(f);

		if (result == true) {
			System.out.println("Food Is Entered");
			RequestDispatcher rd = req.getRequestDispatcher("FoodAdd.jsp");
			rd.include(req, res);
		} else {
			System.out.println("Food Not Inserted");
			RequestDispatcher rd = req.getRequestDispatcher("FoodAdd.jsp");
			rd.include(req, res);
		}
		
		out.close();
	}
}
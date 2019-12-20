package com.tyagi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showCart")
public class ShowCart {

	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
		
		request.getRequestDispatcher("/ShowCart.jsp").forward(request, response);
		
	}
}


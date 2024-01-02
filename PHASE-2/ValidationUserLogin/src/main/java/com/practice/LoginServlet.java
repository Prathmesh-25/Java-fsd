package com.practice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	 ServletException, IOException {
	 String UserName = request.getParameter("email");
	 String password = request.getParameter("password");
	 String correctUserName = "admin@example.com";
	 String correctPassword = "admin123";
	 if (UserName.equals(correctUserName) && password.equals(correctPassword)) {
	 HttpSession session = request.getSession();
	 session.setAttribute("user", UserName);
	 response.sendRedirect("dashboard");
	 } 
	 else {
	 request.setAttribute("error", "Invalid email or password");
	 request.getRequestDispatcher("error.jsp").forward(request, response);
	 }
	}
}
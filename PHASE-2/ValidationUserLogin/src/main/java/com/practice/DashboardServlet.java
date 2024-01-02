package com.practice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class DashboardServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
	 HttpSession session = request.getSession(false);
	 if (session != null && session.getAttribute("user") != null) {
	 request.getRequestDispatcher("dashboard.html").forward(request, response);
	 } else {
	 response.sendRedirect("login.html");
	 }
	 }
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
	 HttpSession session = request.getSession(false);

	 if (session != null) {
	 session.invalidate();
	 }
	 response.sendRedirect("login.html");
	 }
}
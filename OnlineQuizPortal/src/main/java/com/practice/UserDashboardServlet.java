package com.practice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "UserDashboardServlet", urlPatterns = "/UserDashboardServlet")
public class UserDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Check if the user is logged in
		if (request.getSession().getAttribute("userFullName") != null) {
			// Forward to the userDashboard.jsp page
 
			request.getRequestDispatcher("userDashboard.jsp").forward(request, response);
		} else {
			// If not logged in, redirect to the login page
			response.sendRedirect("userLogin.jsp");
		}
	}
}
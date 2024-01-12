package com.practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.practice.util.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(name ="AdminLoginServlet", urlPatterns ="/adminLogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String adminUsername;
	private String adminPassword;
	@Override
	public void init() throws ServletException {
		// Retrieve init parameters from web.xml 
		adminUsername = getServletConfig().getInitParameter("adminUsername");
		adminPassword = getServletConfig().getInitParameter("adminPassword");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// Hardcoded admin credentials (replace these with secure methods in a real application)
		if (adminUsername.equals(username) && adminPassword.equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("adminFullName", "Admin User");
			response.sendRedirect("AdminDashboardServlet");
		} else {
 
			response.sendRedirect("adminLogin.jsp?error=true");
		}
	}
	public boolean authenticateAdminUser(String username, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean isAuthenticated = false;
		try {
			connection = DBUtil.getConnection();
			String query = "SELECT * FROM admin_users WHERE username = ? AND password = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			isAuthenticated = resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace(); 
		} finally {
			// Close the resources 
			closeResources(resultSet, preparedStatement, connection);
		}
		return isAuthenticated;
	}
	// Utility method to close resources
	private void closeResources(ResultSet resultSet, 
			PreparedStatement preparedStatement, Connection connection) {
		try {
			if (resultSet != null) 
				resultSet.close();
			if (preparedStatement != null) 
				preparedStatement.close();
			if (connection != null) 
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

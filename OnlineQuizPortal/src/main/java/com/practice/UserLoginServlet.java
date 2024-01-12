package com.practice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.practice.dao.UserDAO;
import com.practice.model.User;
@WebServlet(name = "UserLoginServlet", urlPatterns = "/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDAO userDAO = new UserDAO();
		// Validate the user credentials
		User user = userDAO.authenticateUser(username, password);
		if (user != null) {
			// If authentication is successful, store user details in the session
			// Successful authentication
			String fullName = userDAO.getFullNameByUsername(username);
			int userId = user.getUserId();
			// Set userFullName attribute in the session
			request.getSession().setAttribute("userFullName", fullName);
			request.getSession().setAttribute("userId", userId);
			// Redirect to user dashboard
			response.sendRedirect("userDashboard.jsp");
		} else {
			// Authentication failed
			response.sendRedirect("userLogin.jsp?error=Invalid credentials");
		}
	}
}

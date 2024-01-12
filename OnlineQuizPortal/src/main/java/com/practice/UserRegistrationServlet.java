package com.practice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.practice.dao.UserDAO;
import com.practice.model.User;
@WebServlet(name = "UserRegistrationServlet", urlPatterns = "/UserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullName = request.getParameter("fullName");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setFullName(fullName);
		UserDAO userDAO = new UserDAO();
		if (userDAO.registerUser(user)) {
			response.sendRedirect("userLogin.jsp");
		} else {
			response.sendRedirect("registration.jsp");
		}
	}
}

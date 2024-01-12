package com.practice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.practice.dao.AdminProfileDAO;
import com.practice.model.AdminUser;
@WebServlet(name ="AdminUpdateProfileServlet", urlPatterns = "/adminUpdateProfile")
public class AdminUpdateProfileServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve updated profile details from the request parameters
		String adminUsername = (String) 
				request.getSession().getAttribute("adminUsername");
		String newName = request.getParameter("newName");
		// Create an instance of AdminProfileDAO and update the admin profile
		AdminProfileDAO adminProfileDAO = new AdminProfileDAO();
		AdminUser adminUser = adminProfileDAO.getAdminUserByUsername(adminUsername);
		adminUser.setFullName(newName);
		adminProfileDAO.updateAdminProfile(adminUser);
		// Redirect back to the admin dashboard
		response.sendRedirect("admin/dashboard.jsp");
	}
}
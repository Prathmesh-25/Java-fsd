package com.practice;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.practice.dao.AdminDashboardDAO;
@WebServlet(name ="AdminDashboardServlet", urlPatterns ="/AdminDashboardServlet")
public class AdminDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminDashboardServlet is being invoked!");
		AdminDashboardDAO adminDashboardDAO = new AdminDashboardDAO();
		try {
			int totalQuiz = adminDashboardDAO.getTotalQuizCount();
			int totalQuestions = adminDashboardDAO.getTotalQuestionCount();
			int totalUsers = adminDashboardDAO.getTotalUserCount();
			request.setAttribute("totalQuiz", totalQuiz);
			request.setAttribute("totalQuestions", totalQuestions);
			request.setAttribute("totalUsers", totalUsers);
			// Forward to adminDashboard.jsp
			request.setAttribute("successMessage", 
					request.getParameter("success"));
		} catch (Exception e) {
			e.printStackTrace();
			// Forward to adminDashboard.jsp with error message
			request.setAttribute("errorMessage", "Error fetching dashboard data: " + e.getMessage());
		}
	RequestDispatcher dispatcher = 
			request.getRequestDispatcher("adminDashboard.jsp");
	dispatcher.forward(request, response);
	}
}

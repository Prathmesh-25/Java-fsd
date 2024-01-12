package com.practice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import com.practice.dao.QuizDAO;
import com.practice.model.QuizParticipation;
@WebServlet(name = "ViewLeaderboardServlet", urlPatterns = "/ViewLeaderboardServlet")
public class ViewLeaderboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// Get the quiz ID from the request parameter
		int quizId = Integer.parseInt(request.getParameter("quizId"));
		// Get the leaderboard information from the database
		List<QuizParticipation> leaderboard = getLeaderboard(quizId);
		// Set the leaderboard as a request attribute
		request.setAttribute("leaderboard", leaderboard);
		// Forward to the viewLeaderboard.jsp page
 
		request.getRequestDispatcher("viewLeaderboard.jsp").forward(request, response);
	}
	private List<QuizParticipation> getLeaderboard(int quizId) 
	{
		// Use QuizDAO to fetch the leaderboard from the database
		QuizDAO quizDAO = new QuizDAO();
		return quizDAO.getQuizLeaderboard(quizId);
	}
}
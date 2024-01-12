package com.practice;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import com.practice.dao.QuizDAO;
import com.practice.model.Quiz;
@WebServlet(name = "ViewQuizzesServlet", urlPatterns = "/ViewQuizzesServlet")
public class ViewQuizzesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		QuizDAO quizDAO = new QuizDAO();
		// Retrieving all quizzes from the database
		List<Quiz> allquiz = quizDAO.getAllQuizzes();
		// Setting all quizzes as a request attribute with the correct name
		request.setAttribute("allquiz", allquiz);
		System.out.println("Number of Quizzes: " + allquiz.size());
		for (Quiz quiz : allquiz) {
			System.out.println("Quiz ID: " + quiz.getQuizId() + ", Quiz Name: " + quiz.getQuizName());
		}
		// Forward to the viewQuizzes.jsp page
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("viewQuizzes.jsp");
		dispatcher.forward(request, response);
	}
}

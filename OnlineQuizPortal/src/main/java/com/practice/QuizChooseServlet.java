package com.practice;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletContext;
import com.practice.dao.QuizDAO;
import com.practice.model.Option;
import com.practice.model.Question;
import com.practice.model.Quiz;
@WebServlet(name = "QuizChooseServlet", urlPatterns = "/quiz-choose")
public class QuizChooseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get quizId from the request parameter
		String quizIdParam = request.getParameter("quizId");
		ServletContext servletContext = getServletContext();
		if (quizIdParam != null) {
			int quizId = Integer.parseInt(quizIdParam);
			// Retrieve questions and options for the specified quiz from the database
			QuizDAO quizDAO = new QuizDAO();
			Quiz quiz = quizDAO.getQuizById(quizId);
			List<Question> questions = 
					quizDAO.getQuestionsForQuiz(quizId);
			List<Option> options = 
					quizDAO.getOptionsForQuiz(quizId);
			// Set quiz, questions, and options as request attributes
			request.setAttribute("quiz", quiz);
			request.setAttribute("questions", questions);
			request.setAttribute("options", options);
			request.setAttribute("quizName", quiz.getQuizName());
			servletContext.setAttribute( "questions", questions );
 // For debugging purpose - options
/* System.out.println("Options: ");
 for (Option option : options) {
 System.out.println("Option ID: " + 
option.getOptionId());
 System.out.println("Option Text: " + 
option.getOptionText());
 System.out.println("Is Correct: " + 
option.isCorrect());
 System.out.println("---");
 }
*/
 // Forward to the quizAttempt.jsp page
			RequestDispatcher dispatcher = request.getRequestDispatcher("quizAttempt.jsp");
			dispatcher.forward(request, response);
		} else {
			//case where quizId is not provided
			response.sendRedirect("userDashboard.jsp");
		}
	}
}

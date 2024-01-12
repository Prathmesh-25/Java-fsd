package com.practice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import com.practice.dao.QuestionDAO;
import com.practice.dao.QuizDAO;
import com.practice.model.Question;
@WebServlet(name ="CreateQuizServlet", urlPatterns ="/CreateQuizServlet")
public class CreateQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Fetching available questions from the database
		List<Question> availableQuestions = getAvailableQuestions();
		// Set available questions as a request attribute
		request.setAttribute("availableQuestions", availableQuestions);
		// Forward to the createQuiz.jsp page
		request.getRequestDispatcher("createQuiz.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String quizName = request.getParameter("quizName");
		String[] selectedQuestions = 
				request.getParameterValues("selectedQuestions");
		if (quizName != null && selectedQuestions != null && selectedQuestions.length > 0) {
			// Process and store the quiz in the database
			boolean quizCreated = processAndStoreQuiz(quizName, selectedQuestions);
			if (quizCreated) {
				// Redirect to admin dashboard with success message
 
				response.sendRedirect("AdminDashboardServlet?success=Quiz created successfully");
			} else {
				// Redirect to admin dashboard with error message
 
				response.sendRedirect("AdminDashboardServlet?error=Failed to create quiz");
			}
		} else {
			// Redirect to admin dashboard with error message
 
			response.sendRedirect("AdminDashboardServlet?error=Invalid input");
		}
	}

	private List<Question> getAvailableQuestions() {
		// for fetching questions from the database
		QuestionDAO questionDAO = new QuestionDAO();
		List<Question> availableQuestions = 
				questionDAO.getAllQuestions();
		// Log the questions
		for (Question question : availableQuestions) {
			System.out.println("Question ID: " + 
					question.getQuestionId() + ", Text: " + 
					question.getQuestionText());
		}
		return availableQuestions;
	}
	private boolean processAndStoreQuiz(String quizName, 
			String[] selectedQuestions) {
		QuizDAO quizDAO = new QuizDAO();
		try {
			// Storing quiz name in the database
			int quizId = quizDAO.createQuiz(quizName);
			if (quizId > 0) {
				// Storing selected questions for the quiz in the database
				for (String questionId : selectedQuestions) {
					try {
						int parsedQuestionId = Integer.parseInt(questionId);
						quizDAO.addQuestionToQuiz(quizId, parsedQuestionId);
					} catch (NumberFormatException e) {
						// Log or handle the error for nonnumeric input
						System.err.println("Invalid question ID: " + questionId);
					}
				}
				return true; // Quiz created successfully
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false; // Quiz creation failed
	}
}

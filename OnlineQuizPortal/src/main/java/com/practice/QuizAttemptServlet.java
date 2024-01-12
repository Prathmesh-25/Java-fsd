package com.practice;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import com.practice.model.Option;
import com.practice.model.Question;
@WebServlet(name = "QuizAttemptServlet", urlPatterns = "/quizAttempt")
public class QuizAttemptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve quiz and questions from request attributes
		ServletContext servletContext = getServletContext();
		// get the counter
		List<Question> questions =(List<Question>)servletContext.getAttribute( "questions");
 //System.out.println(questions);
 //for (Question questionA : questions) {
 //System.out.println("Question ID: " + questionA.getQuestionId());
 //System.out.println("Question Text: " + questionA.getQuestionText());
 //System.out.println("---");
 //}
 /*System.out.println(request.getParameter("questions"));
 System.out.println(request.getAttribute("questions"));
 List<Question> questions = (List<Question>) 
request.getAttribute("questions");
 
 //For debugging purpose - questions
 System.out.println("Questions:Servlet is running ");
 System.out.println(questions);
 for (Question question : questions) {
 System.out.println("Question ID: " + 
question.getQuestionId());
Online Quiz Portal (Source Codes)
 System.out.println("Question Text: " + 
question.getQuestionText());
 System.out.println("---");
 }*/
 	// Invalidate the existing session
 	request.getSession().invalidate();
 
 	// Create a new session
 	HttpSession newSession = request.getSession(true);
 
 	// Set userScore to 0 for the new session
 	newSession.setAttribute("userScore", 0);
 
 	for (Question question : questions) {
 		String[] selectedOptionsParams = 
 				request.getParameterValues("question_" + question.getQuestionId());
 		if (selectedOptionsParams != null) {
 			int correctOptionsCount = 0;
 			for (String selectedOptionParam : selectedOptionsParams) {
 				int selectedOptionId = Integer.parseInt(selectedOptionParam);
 				// Check if the selected option is correct
 				for (Option option : question.getOptions()) {
 					if (option.getOptionId() == selectedOptionId && option.isCorrect()) {
 						// The selected option is correct
 						correctOptionsCount++;
 						break; // Exit the loop once a correct option is found
 					}
 				}
 			}
 			// Update the user's score based on the number of correct options selected
 			Integer userScore = (Integer) 
 					newSession.getAttribute("userScore");
 			newSession.setAttribute("userScore", userScore + correctOptionsCount);
 			// Print statements for debugging
 			//System.out.println("Correct answers selected for question ID: " + question.getQuestionId());
 				//System.out.println("Number of correct options selected: " + correctOptionsCount);
 				//System.out.println("User's current score: " + (userScore + correctOptionsCount));
 			}
 	}
 
 	// Forward to the quizResult.jsp page (create this page to display the result)
 	response.sendRedirect("quizResult.jsp");
	}
}

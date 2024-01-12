package com.practice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.practice.dao.QuestionDAO;
import com.practice.model.Question;
@WebServlet(name = "AdminAddQuestionServlet", urlPatterns = "/adminAddQuestion")
public class AdminAddQuestionServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// Retrieve question details from the request parameters
		String questionText = request.getParameter("questionText");
		String option1 = request.getParameter("option1");
		String option2 = request.getParameter("option2");
		String option3 = request.getParameter("option3");
		String option4 = request.getParameter("option4");
		String correctOptionString = 
				request.getParameter("correctOption");
		int correctOption = Integer.parseInt(correctOptionString);
 
		// Create an instance of Question and set its properties
		Question question = new Question();
		question.setQuestionText(questionText);
		question.setOption1(option1);
		question.setOption2(option2);
		question.setOption3(option3);
		question.setOption4(option4);
		question.setCorrectOption(correctOption);
		// Create an instance of QuestionDAO and add the question to the database
		QuestionDAO questionDAO = new QuestionDAO();
		questionDAO.addQuestion(question);
		// Redirect back to the admin dashboard
		response.sendRedirect("adminDashboard.jsp");
	}
}

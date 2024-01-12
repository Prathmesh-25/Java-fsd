<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.practice.model.Question" %>
<%@ page import="com.practice.model.Option" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Quiz Attempt</title>
  </head>
  <body>
	<h1>Quiz: <%= request.getAttribute("quizName") %></h1>
	<form action="quizAttempt" method="post">
	<%
 		// Retrieve the list of questions and options from the request
 		List<Question> questions = (List<Question>)request.getAttribute("questions");
		request.setAttribute("questions", questions);
		 if (questions != null) 
		 {
		  	for (Question question : questions) 
		  	{
		 		out.println("<p>" + question.getQuestionText() + "</p>");
		 		// Display the options using the provided Option properties
		 		List<Option> options = question.getOptions();
		 		for (Option option : options) 
		 		{
		 			out.println("<label>");
		 			out.println("<input type=\"radio\" name=\"question_" + question.getQuestionId() + "\" value=\"" + option.getOptionId() + "\">");
					out.println(option.getOptionText());
					out.println("</label><br>");
		 		}
		 		out.println("<hr>");
		 	}
		 } 
		 else 
		 {
		 	out.println("<p>No questions available</p>");
		 }
	 %>
     <input type="submit" value="Submit Quiz">
    </form>
  </body>
</html>
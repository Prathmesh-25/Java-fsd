<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		 <meta charset="UTF-8">
		 <title>Create Quiz</title>
		 <style>
			 /* Add custom styles for horizontal dropdown */
			 select[multiple] {
			 display: block;
			 width: 30%;
			 height: auto;
			 }
		 </style>
	</head>
	<body>
		<form action="CreateQuizServlet" method="post">
			 <label for="quizName">Quiz Name:</label>
			 <input type="text" id="quizName" name="quizName" required>
			 <br>
			 <label>Select Questions for the Quiz:</label>
			<select name="selectedQuestions" multiple="multiple" size="5">
				 <c:forEach var="question" items="${availableQuestions}">
				 <option value="${question.questionId}">${question.questionText}</option>
				 </c:forEach>
			</select>
		 <input type="submit" value="Create Quiz">
		</form>
	</body>
</html>
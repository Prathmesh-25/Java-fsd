<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		 <meta charset="UTF-8">
		 <title>Choose Quiz</title>
	</head>
	<body>
		<h1>Choose Quiz</h1>
		<form action="quiz-choose" method="get">
			 <label for="quizId">Enter Quiz ID:</label>
			 <input type="text" id="quizId" name="quizId" required>
			 <input type="submit" value="Start Quiz">
		</form>
	</body>
</html>
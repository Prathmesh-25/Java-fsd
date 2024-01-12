<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	 <meta charset="UTF-8">
	 <title>Quiz Result</title>
	</head>
	<body>
	<h1>Quiz Result</h1>
	<%
	 // Retrieve the user's score from the session
	int userScore = (int) 
	request.getSession().getAttribute("userScore");
	 // Output the user's score
	 out.println("<p>Your Score: " + userScore + "</p>");
	%>
	</body>
</html>
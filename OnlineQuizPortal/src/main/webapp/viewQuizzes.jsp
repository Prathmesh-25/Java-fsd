<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
 <title>Available Quizzes</title>
 <style>
 table {
 border-collapse: collapse;
 width: 50%;
 margin-top: 20px;
 }
 th, td {
 border: 1px solid #dddddd;
 text-align: left;
 padding: 8px;
 }
 th {
 background-color: #f2f2f2;
 }
</style>
</head>
	<body>
		<h1>Quizzes List</h1>
		<table>
			 <thead>
				 <tr>
				 	<th>Quiz ID</th>
				 	<th>Quiz Name</th>
				 </tr>
			 </thead>
			 <tbody>
			 	<c:forEach var="quiz" items="${requestScope.allquiz}">
					 <tr>
						 <td>${quiz.quizId}</td>
						 <td>${quiz.quizName}</td>
					 </tr>
				 </c:forEach>
			 </tbody>
		</table>
	</body>
</html>
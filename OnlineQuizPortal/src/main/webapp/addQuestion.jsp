<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	 <meta charset="UTF-8">
	 <title>Add Question</title>
	</head>
	<body>
		<h1>Add New Questions Here</h1>
		<form action="AdminAddQuestionServlet" method="post">
		 <label for="questionText">Question Text:</label><br>
		 <textarea id="questionText" name="questionText" rows="4" cols="50" required></textarea>
		 <br>
		 <label for="option1">Option 1:</label>
		 <input type="text" id="option1" name="option1" required>
		 <br>
		 <label for="option2">Option 2:</label>
		 <input type="text" id="option2" name="option2" required>
		 <br>
		 <label for="option3">Option 3:</label>
		 <input type="text" id="option3" name="option3" required>
		 <br>
		 <label for="option4">Option 4:</label>
		 <input type="text" id="option4" name="option4" required>
		 <br>
		 <label for="correctOption">Correct Option:</label>
		 <select id="correctOption" name="correctOption" required>
			 <option value="1">Option 1</option>
			 <option value="2">Option 2</option>
			 <option value="3">Option 3</option>
			 <option value="4">Option 4</option>
		 </select>
		 <br>
		 <input type="submit" value="Add Question">
		</form>
	</body>
</html>

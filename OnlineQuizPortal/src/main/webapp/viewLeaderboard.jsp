<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
 <head>
 	<title>Quiz Leaderboard</title>
 </head>
 <body>
 	<h1>Quiz Leaderboard</h1>
	 <table border="1">
		 <tr>
			 <th>User ID</th>
			 <th>Username</th>
			 <th>Score</th>
		 </tr>
		 <c:forEach var="entry" items="${leaderboard}">
			 <tr>
				 <td>${entry.userId}</td>
				 <td>${entry.username}</td>
				 <td>${entry.score}</td>
			 </tr>
		 </c:forEach>
	 </table>
 </body>
</html>
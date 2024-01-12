<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
	<head>
	 	<title>User Registration</title>
	</head>
	<body>
	 <h1>User Registration</h1>
	 <form action="UserRegistrationServlet" method="post">
	 	<label for="username">Username:</label>
	 	<input type="text" id="username" name="username" required>
	 	<br>
		 <label for="password">Password:</label>
		 <input type="password" id="password" name="password" required>
		 <br>
		 <label for="fullName">Full Name:</label>
		 <input type="text" id="fullName" name="fullName" required>
		 <br>
		 <input type="submit" value="Register">
	 </form>
	</body>
</html>

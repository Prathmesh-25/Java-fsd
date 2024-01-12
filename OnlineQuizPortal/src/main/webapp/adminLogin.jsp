<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
 <title>Admin Login</title>
 <style>
 body {
 display: flex;
 flex-direction: column;
 align-items: center;
 margin: 0;
 }
 h1 {
 font-weight: bold;
 margin-top: 50px; 
 /* Adjust the margin as needed*/
 }
 form {
 text-align: center;
 }
 p.error-message {
 color: red;
 }
 </style>
</head>
<body>
	 <h1>Admin Login</h1>
	 <% if (request.getParameter("error") != null) { %>
	 <p class="error-message">Invalid username or password</p>
	 <% } %>
	 <form action="adminLogin" method="post">
	 <label for="username">Username:</label>
	 <input type="text" name="username" required/><br/>
	 <label for="password">Password:</label>
	 <input type="password" name="password" required/><br/>
	 <input type="submit" value="Login"/>
	 </form>
</body>
</html>
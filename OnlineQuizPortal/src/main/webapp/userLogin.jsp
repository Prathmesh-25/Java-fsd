<%@ page contentType="text/html;charset=UTF-8" language="java"
%>
<html>
<head>
 <title>User Login</title>
 <style>
 body {
 text-align: center;
 display: flex;
 flex-direction: column;
 align-items: center;
 justify-content: center;
 height: 100vh;
 margin: 0;
 }
 h1 {
 color: #333;
 }
 form {
 margin-top: 20px;
 }
 label {
 display: block;
 margin-bottom: 5px;
 }
 input {
 padding: 10px;
 margin-bottom: 15px;
 }
 p {
 margin-top: 15px;
 }
 a {
 color: #3498db;
 }
 </style>
</head>
<body>
 <h1>User Login</h1>
 <!-- Display error message if authentication fails -->
 <c:if test="${param.error ne null}">
 <p style="color: red;">${param.error}</p>
Online Quiz Portal (Source Codes)
 </c:if>
 <form action="UserLoginServlet" method="post">
 <label for="username">Username:</label>
 <input type="text" id="username" name="username"
required>
 <br>
 <label for="password">Password:</label>
 <input type="password" id="password" name="password"
required>
 <br>
 <input type="submit" value="Login">
 </form>
 <!-- Add a link for user registration -->
 <p>Don't have an account? <a
href="registration.jsp">Register here</a>.</p>
</body>
</html>
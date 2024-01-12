<%@ page import="com.practice.dao.AdminProfileDAO" %>
<%@ page import="com.practice.model.AdminUser" %>
<%
 String adminUsername = (String) 
session.getAttribute("adminUsername");
 // Check if the admin is logged in, if not, redirect to the login page
 if (adminUsername == null) {
 response.sendRedirect("adminLogin.jsp");
 } else {
 AdminProfileDAO adminProfileDAO = new
AdminProfileDAO();
 AdminUser adminUser = 
adminProfileDAO.getAdminUserByUsername(adminUsername);
%>
<!DOCTYPE html>
<html>
<head>
 <title>Update Admin Profile</title>
</head>
<body>
 <h1>Update Admin Profile</h1>
 <form action="adminUpdateProfile" method="post">
 <label for="newName">New Name:</label>
 <input type="text" id="newName" name="newName"
value="<%= adminUser.getFullName() %>" required>
 <br>
 <input type="submit" value="Update Profile">
 </form>
</body>
</html>
<%
 }
%>
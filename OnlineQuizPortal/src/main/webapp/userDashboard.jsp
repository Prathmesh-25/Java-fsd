<%@ page contentType="text/html;charset=UTF-8" language="java"
%>
<html>
<head>
 <title>User Dashboard</title>
 <style>
 /* Add some basic styling for the buttons */
 .dashboard-button {
 display: inline-block;
 padding: 10px 20px;
 margin: 5px;
 text-align: center;
 text-decoration: none;
 cursor: pointer;
 border: 1px solid #ccc;
 border-radius: 5px;
 background-color: #f2f2f2;
 }
 </style>
</head>
<body>
 <h1>Welcome, <%= session.getAttribute("userFullName") %>
to User Dashboard</h1>
 
 <!-- Display user dashboard content -->
 <div>
 <!-- Use buttons instead of links -->
 <button class="dashboard-button"
onclick="window.location.href='ViewQuizzesServlet'">View 
Available Quizzes</button>
 <button class="dashboard-button"
onclick="window.location.href='chooseQuiz.jsp'">Attempt a 
Quiz</button>
 <button class="dashboard-button"
onclick="window.location.href='viewLeaderboard.jsp'">View
Leaderboard</button>
 </div>
 <!-- Display user dashboard content -->
 <div>
 <!-- Add more content as needed -->
 </div>
</body>
</html>

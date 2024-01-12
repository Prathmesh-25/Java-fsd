<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
 <head>
	 <title>Admin Dashboard</title>
	 <style>
		 .button-link {
		 display: inline-block;
		 padding: 10px 20px;
		 text-align: center;
		 text-decoration: none;
		 cursor: pointer;
		 border: 1px solid #ccc;
		 background-color: #f0f0f0;
		 color: #333;
		 border-radius: 5px;
		 }
	 </style>
 </head>
 <body>
   <h1>Welcome, <%= session.getAttribute("adminFullName")%> to Admin Dashboard</h1>
   <!-- Display admin dashboard content -->
   <button class="button-link" onclick="window.location.href='AdminDashboardServlet'">Dashboard</button>
    <!--Link to update admin profile-->
    <button class="button-link" onclick="window.location.href='updateProfile.jsp'">Update Profile</button>
    <!--Link to Create Quiz -->
    <button class="button-link" onclick="window.location.href='createQuiz.jsp'">Create Quiz</button>
    <!--Link to add Questions -->
    <button class="button-link" onclick="window.location.href='addQuestion.jsp'">Add Quiz Question</button>
    <!--Link to view Leaderboard -->
    <button class="button-link" onclick="window.location.href='viewLeaderboard.jsp'">View Leaderboard</button>
    <!-- Display admin dashboard content -->
	 <div>
	 <h3>Total Quiz: ${totalQuiz}</h3>
	 <h3>Total Questions: ${totalQuestions}</h3>
	 <h3>Total Users: ${totalUsers}</h3>
	 </div>
</body>
</html>
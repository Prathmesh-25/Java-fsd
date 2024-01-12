package com.practice;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	
    	PrintWriter pw = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        String userEmail = "username@email.com" ;
        String userPassword =  "password@123";
        
        if (userEmail.equals(email) && userPassword.equals(password)) {
        	request.getRequestDispatcher("/dashboard.html").forward(request, response);
        }
        else {
        	request.getRequestDispatcher("/error.html").forward(request, response);
        }
        
        pw.close();
        
    }
}
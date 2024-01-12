package com.practice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AccountDashboard", urlPatterns ="/AccountDashboard")
public class AccountDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AccountDashboard() {
        super();
        
    }

        
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
                response.getWriter().write("I am in Account Dashboard after passing through LoginFilter");
    }

        
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
                doGet(request, response);
    }

}

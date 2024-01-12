package com.practice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "AccountProfile", urlPatterns ="/AccountProfile")
public class AccountProfile extends HttpServlet {
        private static final long serialVersionUID = 1L;
       

    public AccountProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {         
    	response.getWriter().write("I am in Account Profile after passing through LoginFilter");
    }

        
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }

}

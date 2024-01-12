package com.practice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NameServlet", urlPatterns = "/NameServlet")
public class NameServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
    public NameServlet() {
        super();
        
    }

        
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                String fname = request.getParameter("fname");
                String lname = request.getParameter("lname");
                
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("Your full name is " + fname + " " + lname);
                out.println("</body></html>");
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                doGet(request, response);
        }

}


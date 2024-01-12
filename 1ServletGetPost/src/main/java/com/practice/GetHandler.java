package com.practice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetHandler", urlPatterns = "/GetHandler")
public class GetHandler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body>");

            String name = request.getParameter("name");
            String address = request.getParameter("address");
            out.println("Name=" + name + "<br>Address=" + address);

            out.println("</body></html>");
        } catch (IOException e) {
            // Handle IOException appropriately
            e.printStackTrace(); // Log the exception or perform other error handling
        }
    }
}
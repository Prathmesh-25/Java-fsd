package com.practice;

import com.practice.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name ="ProductServlet", urlPatterns = "/productServlet")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String productName = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));

        // Create a Product object
        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);

        // Store the product in the session
        HttpSession session = request.getSession();
        session.setAttribute("product", product);

        // Redirect to the second JSP page
        response.sendRedirect("displayProduct.jsp");
    }
}
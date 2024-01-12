package com.practice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "ProductDetailsServlet", urlPatterns ="/ProductDetailsServlet")
public class ProductDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
 
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
 
            // Establish a connection
            String jdbcUrl = "jdbc:mysql://localhost:3306/ecommerce";
            String username = "root";
            String password = "Shiv@vardan1";
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
 
            // Prepare and execute the SQL query
            String sql = "SELECT * FROM products WHERE product_id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, productId);
                ResultSet resultSet = statement.executeQuery();
 
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
 
                if (resultSet.next()) {
                    // Display the details of the products
                    out.println("<html><body>");
                    out.println("<h2>Product Details:</h2>");
                    out.println("<p>Product Id: " + resultSet.getInt("product_id") + "</p>");
                    out.println("<p>Name: " + resultSet.getString("name") + "</p>");
                    out.println("<p>Cost: Rs" + resultSet.getBigDecimal("cost") + "</p>");
                    out.println("</body></html>");
                } else {
                    // display error message 
                    out.println("<html><body>");
                    out.println("<h2>Error Occured:</h2>");
                    out.println("<p>Product not found for Product Id : " + productId + "</p>");
                    out.println("</body></html>");
                }
            }
 
            // Close the connection
            connection.close();
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

<%@ page import="com.practice.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Details</title>
</head>
<body>
    <h2>Product Details</h2>
    <%
        // Retrieve product from the session
        Product product = (Product) session.getAttribute("product");

        // Display product details
        if (product != null) {
    %>
            <p><strong>Product Name:</strong> <%= product.getProductName() %></p>
            <p><strong>Price:</strong> <%= product.getPrice() %></p>
            <!-- Add other product details as needed -->
    <%
        } else {
    %>
            <p>No product details available.</p>
    <%
        }
    %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
    <form action="AddProductServlet" method="post">
        Product Name: <input type="text" name="productName" required><br>
        Price: <input type="number" name="price" required><br>
        <input type="submit" value="Add Product">
    </form>
</body>
</html>
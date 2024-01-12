package com.practice;

//AddProductServlet.java

import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AddProductServlet", urlPatterns ="/AddProductServlet")
public class AddProductServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

 @SuppressWarnings("deprecation")
protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
     
	 String productName = request.getParameter("productName");
     double price = Double.parseDouble(request.getParameter("price"));

     Product prdt = new Product();
     prdt.setProductName(productName);
     prdt.setPrice(price);

     Configuration config = new Configuration();
     config.configure("com/practice/hibernate.cfg.xml");
     SessionFactory sessionFactory = config.buildSessionFactory();
     Session ses = sessionFactory.openSession();

     Transaction transaction = ses.beginTransaction();
     ses.save(prdt);
     transaction.commit();

     ses.close();

     response.sendRedirect("addProduct.jsp");
 }
}
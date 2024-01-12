package com.ecommerce;
import java.io.IOException;

import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.*;
import jakarta.xml.bind.*;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet(name = "ListProducts", urlPatterns = "/list")
public class ListProducts extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public ListProducts() {
        super();
    }

        
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
                        
            Session session = sessionfactory.openSession();
            // using HQL
            List<EProduct> list = session.createQuery("from EProduct").list();
                        
            session.close();
                        
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<b>Product Listing</b><br>");
            for(EProduct p: list) {
            	out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.getName() +
                ", Price: " + String.valueOf(p.getPrice()) + ", Date Added: " + p.getDateAdded().toString() + "<br>");
            }
                         
            out.println("</body></html>");
                     
                     
            } catch (Exception ex) {
            	throw ex;
            }
                    
        }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	doGet(request, response);
    }

}

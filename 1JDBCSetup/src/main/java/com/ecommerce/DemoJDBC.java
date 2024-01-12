package com.ecommerce;

import com.ecommerce.DBConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "DemoJDBC", urlPatterns ="/DemoJDBC")
public class DemoJDBC extends HttpServlet {
        private static final long serialVersionUID = 1L;
    
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
        	PrintWriter out = response.getWriter();
                
        	
        	    
        	    out.println("<html><body>");

        	    InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
        	    Properties props = new Properties();
        	    props.load(in);

        	    DBConnection conn;
				try {
					conn = new DBConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));
					conn.closeConnection();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	    out.println("DB Connection initialized.<br>");

        	    // Do something with the connection if needed

        	    // Close the connection
        	    
        	    out.println("DB Connection closed.<br>");

        	    out.println("</body></html>");
        	    out.close();
        	
        	
        }

}

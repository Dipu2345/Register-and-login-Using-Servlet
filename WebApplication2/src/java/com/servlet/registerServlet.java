/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author DEBASHIS
 */
public class registerServlet extends HttpServlet {

  
            
 
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException,ServletException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name  = request.getParameter("name");
        String number  = request.getParameter("number");
        String password  = request.getParameter("password");
        out.println("<h1 style='color:green;text-align:center'>Welcome</h1>");
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dipu");
          
            PreparedStatement psmt = con.prepareStatement("INSERT INTO link VALUES(?,?,?)");
             psmt.setString(1,name);
             psmt.setString(2,number);
             psmt.setString(3, password);
            
             int n = psmt.executeUpdate();
             if(n>0){
                 out.println("<h2 style='color:green;text-align:center'>Record Inserted</h2>");
             }
             else{
                 out.println("<h2 style='color:red;text-align:center'>Record  not Inserted</h2>");
             }
             Statement smt = con.createStatement();
             ResultSet rs = smt.executeQuery("SELECT * from link");
             while(rs.next()){
                 
                 String fname = rs.getString("ename");
                 String number1 = rs.getString("mob_no");
                 String password1 = rs.getString("password");
                    out.println("<html><body><h2 style='color:blue;text-align:center'>name :"+fname+"</h2></body></html>");
                    out.println("<html><body><h3 style='color:blue;text-align:center'>mob-number :"+number1+"</h3></body></html>");
                   out.println("<html><body><h4 style='color:blue;text-align:center'>password :"+password1+"</h4></body></html>");
                     out.println("<br>");
             }
        }
       
        catch(ClassNotFoundException | SQLException e){
           
        }
        
    }
               

        
   
}

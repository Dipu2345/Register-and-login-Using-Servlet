
package com.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.sql.*;
public class HelloServlet extends HttpServlet {
    @Override
      public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
          response.setContentType("text/html");
        PrintWriter out = response.getWriter();
           String name  = request.getParameter("name");
        String password  = request.getParameter("password");
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dipu");
            PreparedStatement psmt = con.prepareStatement("Select * from link where ename=? and password=?");
             psmt.setString(1,name);
           psmt.setString(2, password);
            ResultSet rs = psmt.executeQuery();
            if(rs.next()){
            out.println("<h1style='color:green;text-align:center'>Login Sucessful</h1>");
            }
            else{
                out.println("<h1style='color:red;text-align:center'>Username or Password Mismatch</h1>");
            }
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
          
    
    
        
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

package servletclass;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.*;
import javax.servlet.http.*;


public class ProductUpdate extends HttpServlet{
  public void service(HttpServletRequest request,HttpServletResponse response)
  throws ServletException, IOException {
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  out.println("update product");
  int  id=Integer.parseInt(request.getParameter("id"));
  request.setAttribute("id", id);
  request.getRequestDispatcher("/Updateproduct.jsp").forward(request, response);
 
}
}
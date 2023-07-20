package servletclass;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.*;
import javax.servlet.http.*;


public class ShowCart extends HttpServlet{

  public void service(HttpServletRequest request,HttpServletResponse response)
  throws ServletException, IOException {
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  out.println("<html>");
  out.println("<body>");
  out.println("<h1>Show Cart</h1> ");
  out.println("</body></html>");
}
}
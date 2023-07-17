package servletclass;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.*;
import javax.servlet.http.*;

public class Home extends HttpServlet{
  public void service(HttpServletRequest request,
  HttpServletResponse response)
  throws ServletException, IOException {
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  String name = request.getParameter("uname");
  out.println("<html>");
  out.println("<body>");
  out.println("Thanks  Mr."+ name+"<br>");
  out.println("</body></html>");
 
        response.sendRedirect(request.getContextPath() + "/index.jsp");

}
}
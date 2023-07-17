package servletclass;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.*;
import javax.servlet.http.*;

public class AddProduct extends HttpServlet{
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
  Connection connection=null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
			PreparedStatement stmt;
			String query="insert into  emp1(name) values(?)";
			stmt=connection.prepareStatement(query);
			stmt.setString(1,"name");
			
			
			int row=stmt.executeUpdate(); // it returns no of rows affected.
			
			if(row>0)
			{
        response.sendRedirect(request.getContextPath() + "/welcome.jsp");
			}
  }
  catch(Exception e){
    System.out.println(e);
  }
}
}
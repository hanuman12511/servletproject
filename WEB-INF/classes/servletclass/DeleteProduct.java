package servletclass;


   import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.*;
import javax.servlet.http.*;


public class DeleteProduct extends HttpServlet{
  public void service(HttpServletRequest request,HttpServletResponse response)
  throws ServletException, IOException {
  response.setContentType("text/html");
  int  id=Integer.parseInt(request.getParameter("id"));
  PrintWriter out = response.getWriter();
  out.println("Delete ="+id);
  Connection connection=null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
			PreparedStatement stmt;
			String query= "DELETE FROM product WHERE id = ?";
			stmt=connection.prepareStatement(query);
			stmt.setInt(1,id);
			
			int row=stmt.executeUpdate(); // it returns no of rows affected.
			
			if(row>0)
			{
				 request.setAttribute("message", "Image added into database successfully.");
  // request.getRequestDispatcher("/Showproduct.jsp").forward(request, response);
               response.sendRedirect("/servletproject/Showproduct.jsp");
              }
			else
			{
				System.out.println("Failed to upload image.");
			}	
		}
		catch (Exception e)
		{
			System.out.println("exc"+e);
		}
  
}
}
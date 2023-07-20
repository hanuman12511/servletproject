package servletclass;


  
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.http.*;

public class SingleProduct extends HttpServlet{
  public void service(HttpServletRequest request,HttpServletResponse response)
  throws ServletException, IOException {
  response.setContentType("text/html");
  String pid =request.getParameter("id");
		response.getWriter().append("Served at: "+pid).append(request.getContextPath());
		request.setAttribute("name", "Hussein Terek");
		request.setAttribute("name1", " Terek");
		request.setAttribute("name2", "Hussein ");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "db";
String userid = "root";
String password = "root";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;

try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from product where id="+pid;
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
int pid1=resultSet.getInt("id");
request.setAttribute("id",  resultSet.getString("id"));
request.setAttribute("name",  resultSet.getString("name"));
request.setAttribute("imagename",  resultSet.getString("imagename"));
request.setAttribute("rate",  resultSet.getString("rate"));
}
		
		
//response.sendRedirect("DetailsProduct.jsp");
		request.getRequestDispatcher("DetailsProduct.jsp").forward(request, response);
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();	
	}
}
}
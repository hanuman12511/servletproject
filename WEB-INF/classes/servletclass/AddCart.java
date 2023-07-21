package servletclass;

  
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;


public class AddCart extends HttpServlet{
     public void service(HttpServletRequest request,HttpServletResponse response)
  throws ServletException, IOException {
  response.setContentType("text/html");



String id =request.getParameter("id");	
		
		PrintWriter pw =response.getWriter();
		

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
String proid=null;
String pname=null;
String pimage=null;
String prate=null;

		try{
		connection = DriverManager.getConnection(connectionUrl+database, userid, password);
		statement=connection.createStatement();
		String sql ="select * from product where id="+id;
		resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
            pw.print("select data product");
		int pid1=resultSet.getInt("id");
		proid= resultSet.getString("id");
		pname= resultSet.getString("name");
		  pimage=resultSet.getString("imagename");
		 prate=resultSet.getString("rate");
		}
			System.out.print(pname);
			System.out.print(pimage);
		
			
			String sql1 ="select count(*) from addtocart where pid="+id;
			resultSet = statement.executeQuery(sql);
            pw.print(resultSet.next());
			if(resultSet.next()){
                  pw.print("insert data update product ");
				System.out.print("*********************************************");
				int qty=resultSet.getInt("qty");
				qty++;
				PreparedStatement stmt;
				String query="update addtocart set qty = ? where pid=?";
				stmt=connection.prepareStatement(query);
				stmt.setInt(1,qty);
				
				stmt.setString(2,proid);
				
				int row=stmt.executeUpdate(); // it returns no of rows affected.
				
				if(row>0) {
					
					 request.setAttribute("message", "Image added into database successfully.");

					 response.sendRedirect("Home.jsp");
						//request.getRequestDispatcher("Home.jsp").forward(request, response);
				}
				
			}
			else {
				
				System.out.print("********************%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*************************");
			  pw.print("insert data product add tocart");
			PreparedStatement stmt;
			String query="insert into  addtocart(pid,qty) values(?,?)";
			stmt=connection.prepareStatement(query);
			stmt.setString(1,proid);
			
			stmt.setInt(2,1);
			int row=stmt.executeUpdate(); // it returns no of rows affected.
			
			if(row>0)
			{response.getWriter().append("Served at: "+pimage+"\n"+row);	
				
				 request.setAttribute("message", "Image added into database successfully.");

				  response.sendRedirect("Home.jsp");
					//request.getRequestDispatcher("Home.jsp").forward(request, response);
			}
			
			else
			{
				System.out.println("Failed to upload image.");
			}
			
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();	
			}
		
		
		
	}
}
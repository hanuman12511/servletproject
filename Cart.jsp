
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
                    pageEncoding="ISO-8859-1"%>
                    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
//String id = request.getParameter("userid");
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
%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>
    <jsp:include page ="Headerbar.jsp" />
<div class="d-flex align-items-start">
  <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">

    
      </div>
 
    <div class="container ">


 	<div class="row ">
    	
    	
	<div class="col ">
    	
 			

<% 
String path=request.getServletContext().getRealPath("images");
System.out.print(path);
int total =0;

try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql =" select *from  addtocart inner join product on addtocart.pid=product.id;";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
	
int pid=resultSet.getInt("pid");
String image=resultSet.getString("imagename");
total+=Integer.parseInt( resultSet.getString("rate"));
%>
<div style="width: max-content; background-color: aquamarine;margin-top: 10px;padding: 10px;">
<a href="SingleProduct?id=<%=pid %>" style="text-decoration: none;">
  
      <img src="images/<%=image %>" style="width:100px"/>
    </a>
  <span><%=resultSet.getString("name") %></span>
  <span>Rate:=<%=resultSet.getString("rate") %>/Rs.</span>
<input type="submit" value="-"><span><%=resultSet.getInt("qty")%></span><input type="submit" value="+">

</div>


<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>

</div>
<div class="col" style="background-color: aqua; height: 300px; position: fixed;width: 400px;right:5%;top:24%">
<p>Total Pay: <%=total%>/Rs.</p>
<input type="submit" value="Order Now">
</div>

 </div>
    
    
    </div>
    
  </div>
  <jsp:include page ="footerbar.jsp" />
  
    </body>
</html>
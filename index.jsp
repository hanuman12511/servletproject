
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
                    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("userid");
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
 
<div class="d-flex align-items-start">
 <jsp:include page ="SideMenu.jsp" />
  <div class="tab-content" id="v-pills-tabContent">
    <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
    <div class="container ">
 	<div class="row ">
    	<div class="col  col-lg-8" style="width:400px ;margin-left: 50%">
    	  <form name="fileform" action="AddImage1" method="post" enctype="multipart/form-data">
    	<div class="mb-3">
 			 <label for="formGroupExampleInput" class="form-label">Add Product Information</label>
  			</div>
    		<div class="mb-3">
 			 <label for="formGroupExampleInput" class="form-label">Product Name:-</label>
  				<input type="text" class="form-control" id="formGroupExampleInput" placeholder="Enter Product Name.." name="name">
				</div>
			<div class="mb-3">
  			<label for="formGroupExampleInput2" class="form-label">Product Rate:-</label>
  			<input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Enter Product Rate..." name="rate">
			</div>
			<div class="mb-3">
  				  Select Image :
  			 <input type="file" name="image">
   					</div>
			<div class="mb-3">
  			<input type="submit" class="form-control" id="formGroupExampleInput2" value="Add Product">
			</div>
		</form>
		
		
<table border="1" width="500px">
<tr>
<td>RsNo.</td>
<td>Image</td>
<td>name</td>
<td>rate</td>

</tr>
<h1>
<% 
String path=request.getServletContext().getRealPath("images");
System.out.print(path);
%>
</h1>

<%

try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from product";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
int pid=resultSet.getInt("id");
%>
<tr>
<td><%=pid %></td>
<td><img src="images/<%=resultSet.getString("imagename") %>" style="width:100px"/></td>
<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("rate") %></td>
<td> <a href="DeleteProduct?id=<%=pid %>">Delete</a></td>
<td> <a href="UpdateProduct?id=<%=pid %>">Edit</a></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table> 
    </div>
   </div>
</div>
    
    
    </div>
    <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">Profile</div>
    <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab">Message</div>
    <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-settings-tab">Seting</div>
  </div>
</div>
  
    </body>
</html>
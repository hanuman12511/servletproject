
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
                    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
int id = (int) request.getAttribute("id");
String name=null;
String rate = null;
String imagename = null;
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
String sql ="select * from product where id= "+id;
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
   
    name=resultSet.getString("name");
    rate=resultSet.getString("rate");
    imagename=resultSet.getString("imagename");

}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}

%>


<!doctype html>
<html lang="en">
  <head>
     <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Hello, world!</title>
  </head>
  <body>
	<jsp:include page ="AdminTop.jsp" />
    <div class="container ">
 	    <div class="row ">
    	    <div class="col  col-lg-8" style="width:400px ;">
    	    <form name="fileform" action="updateproductdata" method="post" enctype="multipart/form-data">
    	    <div class="mb-3">
 			 <label for="formGroupExampleInput" class="form-label">Update Product Information</label>
  			</div>
              <div class="mb-3">
                <label for="formGroupExampleInput" class="form-label">Product id:-</label>
                    <input type="text" class="form-control"  id="formGroupExampleInput" placeholder="Enter Product Name.." name="id" value="<%=id%>">
                  </div>
    		<div class="mb-3">
 			 <label for="formGroupExampleInput" class="form-label">Product Name:-</label>
  				<input type="text" class="form-control" id="formGroupExampleInput" placeholder="Enter Product Name.." name="name" value="<%=name%>">
				</div>
			<div class="mb-3">
  			<label for="formGroupExampleInput2" class="form-label">Product Rate:-</label>
  			<input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Enter Product Rate..." name="rate" value="<%=rate%>">
			</div>
			<div class="mb-3">
  				  Select Image :
  			 <input type="file" name="image" value="images/<%=imagename%>"><img src="images/<%=imagename%>" style="width: 100px;"/>
   					</div>
			<div class="mb-3">
  			<input type="submit" class="form-control" id="formGroupExampleInput2" value="Update Product">
			</div>
		</form>
        </div>
        </div>
        </div>

</body>
</html>
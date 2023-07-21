<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">
  <form action="AddProduct" method="Get">
    <button class="nav-link active mt-3" type="submit" >Add Product</button>
    </form>
    <form action="Showproduct"  method="Get">
    <button class="nav-link active mt-3" type="submit" >Show Product</button>
    </form>
    <form action="productstatus"  method="Get">
      <button class="nav-link active mt-3" type="submit" >Product Status</button>
      </form>
      </div>
</body>
</html>
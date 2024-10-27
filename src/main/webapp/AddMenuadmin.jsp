<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="jay.admin.Admin"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Menu</title>
</head>
<body>
	<%
	Admin ad = (Admin) session.getAttribute("admin");
	%>
	<div>
		<h2><%=ad.getuName()%></h2>
		<a href="adminlogout">Logout</a>
	</div>

	<div>
		<form action="addmenuadmin" method="post" enctype="multipart/form-data">
			Name:<input type="text" name="name"><br>
			Picture:<input type="file" name="pic"><br>
			Quantity:<input type="number" name="qty"><br>
			Price:<input type="text" name="price"><br>
			
			<input type="submit" value="Add Menu">
		</form>
	</div>
</body>
</html>
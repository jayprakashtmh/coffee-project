<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="jay.admin.Admin"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add About</title>
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
		<form action="addaboutadmin" method="post" enctype="multipart/form-data">
			Name:<input type="text" name="name"><br>
			Picture:<input type="file" name="pic"><br>
			Quote Text:<input type="text" name="qtext"><br>
			Description:<input type="text" name="desc"><br>
			
			<input type="submit" value="Add About">
		</form>
	</div>
</body>
</html>
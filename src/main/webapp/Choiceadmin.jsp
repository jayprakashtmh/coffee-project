<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import ="jay.admin.Admin"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Choice</title>
</head>
<body>
	<%
	Admin ad = (Admin)session.getAttribute("admin");
	%>
	<div>
		<h2><%=ad.getuName()%></h2>
		<a href="adminlogout">Logout</a>
	</div>
	
	<div>
		<a href="viewprod">Product</a>
		<a href="viewmenu">Menu</a>
		<a href="viewabout">About</a>
		<a href="viewblog">Blog</a>
	</div>
</body>
</html>        
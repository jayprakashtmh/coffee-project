<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
	<%
	String msg = (String) request.getAttribute("msg");
	%>
	<%@include file="Loginadmin.html"%>
	<p><%=msg %></p>
</body>
</html>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="jay.admin.Admin, jay.admin.content.about.About"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About</title>
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
		<%
		String msg = (String) request.getAttribute("msg");
		%>
		<p><%=msg%></p>

		<%
		About ab = (About) session.getAttribute("about");
		if (ab.getName() != null) {
			String path = "./img/" + ab.getPic_url();
		%>

		<div>
			<div>
				<img alt="" src="<%=path%>" width="150px">
			</div>
			<div>
				<h5><%=ab.getName()%></h5>
				<h5><%=ab.getQtext()%></h5>
				<h5><%=ab.getDesc()%></h5>
			</div>

			<a href="updateabout">Update</a>
		</div>
		<%
		} else {
		%>
			<a href="addabout">Add About</a>
		<%
		}
		%>
	</div>
</body>
</html>
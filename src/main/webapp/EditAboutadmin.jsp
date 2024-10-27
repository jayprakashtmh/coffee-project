<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="jay.admin.Admin, jay.admin.content.about.About"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit About</title>
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
		About ab = (About) session.getAttribute("about");
		%>
		<form action="updateaboutadmin" method="post" enctype="multipart/form-data">
			Name:<input type="text" name="name" value="<%=ab.getName()%>"><br>
			Picture:<input type="file" name="pic"><br>
			Quote Text:<input type="text" name="qtext" value="<%=ab.getQtext()%>"><br>
			Description:<input type="text" name="desc" value="<%=ab.getDesc()%>"><br>

			<input type="submit" value="Update About">
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="jay.admin.Admin, java.util.*, jay.admin.content.blog.Blog"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Blog</title>
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
		@SuppressWarnings("unchecked")
		ArrayList<Blog> alb = (ArrayList<Blog>) session.getAttribute("blogs");
		Iterator<Blog> it = alb.iterator();
		while (it.hasNext()) {
			Blog b = it.next();
			if (b.getId() == Integer.parseInt(request.getParameter("bid"))) {
		%>
		<form action="updateblog" method="post">
			<input type="hidden" value="<%=b.getId()%>" name="bid">
			Name:<input type="text" value="<%=b.getName()%>" readonly><br>
			Description:<input type="text" name="desc" value="<%=b.getDesc()%>"><br>

			<input type="submit" value="Update Blog">
		</form>
		<%
		break;
		}
		}
		%>
	</div>
</body>
</html>
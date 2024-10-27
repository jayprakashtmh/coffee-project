<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="jay.admin.Admin, java.util.ArrayList, jay.admin.content.blog.Blog"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blog</title>
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
		@SuppressWarnings("unchecked")
		ArrayList<Blog> alb = (ArrayList<Blog>) session.getAttribute("blogs");
		Iterator<Blog> it = alb.iterator();
		while (it.hasNext()) {
			Blog b = it.next();
			String path = "./blog_img/" + b.getPic_url();
		%>

		<div>
			<div>
				<img alt="" src="<%=path%>" width="150px">
			</div>
			<div>
				<h5><%=b.getName()%></h5>
				<h5><%=b.getDesc()%></h5>
				<h5><%=b.getDate()%></h5>
			</div>

			<a href="editblog?bid=<%=b.getId()%>">Edit</a>
			<a href="delblog?bid=<%=b.getId()%>">Delete</a>
		</div>

		<%
		}
		%>
		
	</div>
	<a href="addblog">Add Blog</a>
</body>
</html>
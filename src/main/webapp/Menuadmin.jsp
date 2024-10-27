<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="jay.admin.Admin, java.util.ArrayList, jay.admin.content.menu.Menu"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
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
		ArrayList<Menu> alp = (ArrayList<Menu>) session.getAttribute("menus");
		Iterator<Menu> it = alp.iterator();
		while (it.hasNext()) {
			Menu m = it.next();
			String path = "./menu_img/" + m.getPic_url();
		%>

		<div>
			<div>
				<img alt="" src="<%=path%>" width="150px">
			</div>
			<div>
				<h5><%=m.getName()%></h5>
				<h5><%=m.getQty()%></h5>
				<h5><%=m.getPrice()%></h5>
				<h5><%=m.getAvl()%></h5>
			</div>

			<a href="editmenu?mid=<%=m.getId()%>">Edit</a>
			<a href="deactivemenu?mid=<%=m.getId()%>">
			<%
			 if (m.getAvl() == 1) {
			 %> Deactivate <%
			 } else {
			 %> Activate <%
			 }
			 %>
			</a>
		</div>

		<%
		}
		%>
		
	</div>
	<a href="addmenu">Add Menu</a>
</body>
</html>
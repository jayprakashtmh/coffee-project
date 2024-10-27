<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="jay.admin.Admin, java.util.*, jay.admin.content.menu.Menu"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Product</title>
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
	ArrayList<Menu> alp = (ArrayList<Menu>) session.getAttribute("menus");
	Iterator<Menu> it = alp.iterator();
	while (it.hasNext()) {
		Menu m = it.next();
		if(m.getId()==Integer.parseInt(request.getParameter("mid"))){
	%>
		<form action="updatemenu" method="post">
			<input type="hidden" value="<%=m.getId() %>" name="mid" >
			Name:<input type="text" value="<%=m.getName()%>" readonly><br>
			Quantity:<input type="number" name="qty" value="<%=m.getQty()%>"><br>
			Price:<input type="text" name="price" value="<%=m.getPrice() %>"><br>
			
			<input type="submit" value="Update Menu">
		</form>
	<%
	break;
	}} %>
	</div>
</body>
</html>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="jay.admin.Admin, java.util.ArrayList, jay.admin.content.product.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
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
		ArrayList<Product> alp = (ArrayList<Product>) session.getAttribute("prods");
		Iterator<Product> it = alp.iterator();
		while (it.hasNext()) {
			Product p = it.next();
			String path = "./product_img/" + p.getPic_url();
		%>

		<div>
			<div>
				<img alt="" src="<%=path%>" width="150px">
			</div>
			<div>
				<h5><%=p.getName()%></h5>
				<h5><%=p.getQty()%></h5>
				<h5><%=p.getPrice()%></h5>
				<h5><%=p.getRating()%></h5>
				<h5><%=p.getAvl()%></h5>
			</div>

			<a href="editprod?pid=<%=p.getId()%>">Edit</a> <a
				href="deactive?pid=<%=p.getId()%>">
			<%
			 if (p.getAvl() == 1) {
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
	<a href="addprod">Add Product</a>
</body>
</html>
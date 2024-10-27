<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="jay.admin.Admin, java.util.*, jay.admin.content.product.Product"%>
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
	ArrayList<Product> alp = (ArrayList<Product>) session.getAttribute("prods");
	Iterator<Product> it = alp.iterator();
	while (it.hasNext()) {
		Product p = it.next();
		if(p.getId()==Integer.parseInt(request.getParameter("pid"))){
	%>
		<form action="updateproduct" method="post">
			<input type="hidden" value="<%=p.getId() %>" name="pid" >
			Name:<input type="text" value="<%=p.getName()%>" readonly><br>
			Quantity:<input type="number" name="qty" value="<%=p.getQty()%>"><br>
			Price:<input type="text" name="price" value="<%=p.getPrice() %>"><br>
			Rating:<input type="number" name="rating" value="<%=p.getRating() %>" min=1 max=5><br>
			
			<input type="submit" value="Update Product">
		</form>
	<%
	break;
	}} %>
	</div>
</body>
</html>
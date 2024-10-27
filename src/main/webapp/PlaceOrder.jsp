<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="jay.admin.content.menu.Menu, jay.admin.content.product.Product, java.util.*,jay.ui.user.address.Address"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Place Order</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link rel="stylesheet" href="style.css">
</head>
<body>

	<%@include file="nav.jsp"%>

	<section class="menu" id="menu">
		<h1 class="heading">
			place <span>order</span>
		</h1>

		<%
		String img = null;
		String name = null;
		double price = 0.0;
		int qty = 0;
		int id = 0;
		String s = (String) request.getParameter("type");
		int pid = Integer.parseInt(request.getParameter("pid"));
		if (s.equals("menu")) {
			@SuppressWarnings("unchecked")
			ArrayList<Menu> alm = (ArrayList<Menu>) request.getAttribute("data");
			Iterator<Menu> it = alm.iterator();
			while (it.hasNext()) {
				Menu m = it.next();
				if (m.getId() == pid) {
			img = "./menu_img/" + m.getPic_url();
			name = m.getName();
			price = m.getPrice() - m.getPrice() * 0.1;
			qty = m.getQty();
			id = m.getId();
			break;
				}
			}
		} else {
			@SuppressWarnings("unchecked")
			ArrayList<Product> alp = (ArrayList<Product>) request.getAttribute("data");
			Iterator<Product> it = alp.iterator();
			while (it.hasNext()) {
				Product p = it.next();
				if (p.getId() == pid) {
			img = "./product_img/" + p.getPic_url();
			name = p.getName();
			price = p.getPrice() - p.getPrice() * 0.1;
			qty = p.getQty();
			id = p.getId();
			break;
				}
			}
		}
		%>

		<div class="box-container">

			<div class="box">
				<img src=<%=img%> alt="">
				<h3><%=name%></h3>
				<div class="price">
					&#8377;<%=price%></div>
				<div class="price">
					Avl. Quantity :
					<%=qty%></div>
			</div>
		</div>
		<div class="box-container form-view">
			<form action="checkout" id="form" method="post">
				<div>
					<input type="hidden" name="pid" value="<%=id%>"> <input
						type="hidden" name="uid" value="<%=u.getId()%>"> <input
						type="hidden" name="type" value="<%=s%>"> <input
						type="number" id="qty" name="qty" min="1" max="<%=qty%>"
						placeholder="Enter Qty" onchange="calTotal()"> <input
						type="hidden" id="price" name="price" value="<%=price%>">
					<input type="text" id="ttlPrice" name="totalPrice" readonly>
				</div>
				<div>
					<%
					boolean isAddress = false;
					@SuppressWarnings("unchecked")
					ArrayList<Address> al = (ArrayList<Address>) session.getAttribute("address");
					if (!al.isEmpty()) {
						isAddress = true;
						Iterator<Address> it = al.iterator();
						while (it.hasNext()) {
							Address a = it.next();
					%>
					<div>
						<input type="radio" name="addr" value="<%=a.getId()%>">
						<p><%=a.getDoorNo()%>,
							<%=a.getStreet()%>,
							<%=a.getCity()%>,
							<%=a.getPin()%>,
							<%=a.getState()%>,
							<%=a.getCountry()%></p>
					</div>
					<%
					}
					}
					%>
				</div>
			</form>
		</div>
		<%
		if (isAddress) {
		%>
		<a class="btn" href="#" onclick="submitData(); return false;">Pay</a>
		<%
		} else {
		%>
		<a href="addaddress?cid=<%=u.getId()%>" class="btn">Add Address</a>
		<%
		}
		%>
	</section>

	<script>
		function submitData() {
			var qty1 = parseInt(document.getElementById("qty").value);
			if (qty1 <=
	<%=qty%>
		) {
				document.getElementById("form").submit();
			} else {
				alert("Please Check Quantity!!");
			}
		}

		function calTotal() {
			var qty1 = parseInt(document.getElementById("qty").value);
			var pr =
	<%=price%>
		;
			if (qty1 <=
	<%=qty%>
		) {
				var tP = qty1 * pr;
				document.getElementById("ttlPrice").value = tP.toFixed(2);
			} else {
				alert("Please Check Quantity!!");
			}
		}
	</script>


	<script src="style.js"></script>


</body>
</html>
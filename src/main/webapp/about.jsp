<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="jay.admin.content.about.About"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>About Us</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%@include file="nav.jsp"%>
	<section class="about" id="about">
		<h1 class="heading">
			<span>about</span> Us
		</h1>

		<div class="row">
			<div class="image">
			<%
            About ab = (About) request.getAttribute("about");
    			String path = "./img/" + ab.getPic_url();
            %>
				<img src="<%=path %>" alt="">
			</div>

			<div class="content">
				<h3><%=ab.getName()%></h3>
				<p><%=ab.getQtext()%></p>
				<p><%=ab.getDesc()%></p>
				<a href="#" class="btn">learn more</a>
			</div>
		</div>
	</section>


    <script src="style.js"></script>
</body>
</html>
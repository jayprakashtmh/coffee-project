<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="jay.ui.user.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update</title>
<link rel="stylesheet" href="login.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
</head>
<body>
	
	<header>
		<ul>
			<li><a href="index.jsp" onclick="toggle()">HOME</a></li>
		</ul>

		<div class="toggle" onclick="toggle()"></div>
	</header>


	<section>
		<div class="container">

			<form action="updateprofile" method="post">

				<h2>Update</h2>
	<%
	User u = (User)session.getAttribute("user");
	%>

				<div class="inputBox">
					<input type="text" name="name" value=<%=u.getName()%> required="required">
					<i class="fa-regular fa-user"></i> <span>Name</span>
				</div>

				<div class="inputBox">
					<input type="number" name="phno" id="phno" value=<%=u.getPhno()%> required="required">
					<i class="fa-solid fa-phone"></i> <span>Phone</span>
				</div>

				<div class="inputBox">
					<input type="password" required="required" value=<%=u.getPword()%> name="pword" id="password1">
					<i class="fa-solid fa-lock"></i> <span>New Password</span>
					<div id="toggle1" onclick="showHide1();"></div>
				</div>

				<div class="inputBox">
					<input type="submit" value="Update Account">
				</div>

			</form>
		</div>
	</section>

	<script src="login.js"></script>

</body>
</html>
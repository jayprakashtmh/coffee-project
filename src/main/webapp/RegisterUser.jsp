<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register</title>
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

			<form action="reguser" id="validCheck" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">

				<h2>Sign Up</h2>

				<div class="inputBox">
					<input type="text" name="name" required="required">
					<i class="fa-regular fa-user"></i> <span>Name</span>
				</div>

				<div class="inputBox">
					<input type="email" name="email" id="email" required="required">
					<i class="fa-regular fa-envelope"></i> <span>Email</span>
				</div>

				<div class="inputBox">
					<input type="number" name="phno" id="phno" required="required">
					<i class="fa-solid fa-phone"></i> <span>Phone</span>
				</div>
				
				<div class="inputBox">
					<input type="file" name="pic" accept="image/*" required="required"> 
                    <i class="fa-solid fa-image"></i> <span>Picture</span>
				</div>

				<div class="inputBox">
					<input type="password" name="pword" required="required" id="password">
					<i class="fa-solid fa-lock"></i> <span>Create Password</span>
					<div id="toggle" onclick="showHide();"></div>
				</div>

				<div class="inputBox">
					<input type="password" required="required" id="password1">
					<i class="fa-solid fa-lock"></i> <span>Confirm Password</span>
					<div id="toggle1" onclick="showHide1();"></div>
				</div>

				<div class="inputBox">
					<input type="submit" id="submit" value="Create Account">
				</div>

				<p>
					Already a member ? <a href="LoginUser.jsp" class="login">Log in</a>
				</p>
			</form>
		</div>
	</section>

	<script src="login.js"></script>
	<script src="validate.js"></script>

</body>
</html>
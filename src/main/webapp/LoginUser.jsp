<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  <link rel="stylesheet" href="login.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
</head>
<body>
  <header>
    <ul>
        <li><a href="index.jsp" onclick="toggle()">HOME</a></li>
        <li><a href="Loginadmin.html" onclick="toggle()">ADMIN</a></li>
    </ul>

    <div class="toggle" onclick="toggle()"></div>
</header>
  <section>
    <div class="container">


      <form action="loginuser" method="post">
        <h2>Sign In</h2>
        <%
		String str = (String)request.getAttribute("msg");
		if(str!=null){
		%>
		<p><%=str%></p>
		<%} %>
        <div class="inputBox">
          <input type="text" name="email" required="required">
          <i class="fa-regular fa-user"></i>
          <span>Email</span>
        </div>
        <div class="inputBox">
          <input type="password" name="pword" required="required" id="password2">
          <i class="fa-solid fa-lock"></i>
          <span>Password</span>
          <div id="toggle2" onclick="showHide2();"></div>
        </div>
        <div class="inputBox">
          <input type="submit" value="Login">
        </div>
        <p>Not Registered ? <a href="RegisterUser.jsp" class="create">Create an Account</a>
      </form>
  
	
  
    </div>
  </section>

<script src="login.js"></script>

</body>
</html>
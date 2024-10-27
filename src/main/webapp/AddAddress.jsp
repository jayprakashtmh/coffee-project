<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Add Address</title>
  <link rel="stylesheet" href="login.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
</head>
<body>
  <header>
    <ul>
        <li><a href="index.jsp" onclick="toggle()">HOME</a></li>
        <li><a href="address" onclick="toggle()">Address</a></li>
    </ul>

    <div class="toggle" onclick="toggle()"></div>
</header>
  <section>
    <div class="container">


      <form action="addcustaddr" method="post">
        <h2>Add Address</h2>
        <%
        int id=Integer.parseInt(request.getParameter("cid"));
		%>
		
		<input type="hidden" name="cid" value="<%=id%>">
		
        <div class="inputBox">
          <input type="text" name="doorno" required="required">
          <i class="fa-regular fa-user"></i>
          <span>Door No</span>
        </div>
        
        <div class="inputBox">
          <input type="text" name="street" required="required">
          <i class="fa-regular fa-user"></i>
          <span>Street</span>
        </div>

        <div class="inputBox">
          <input type="text" name="city" required="required">
          <i class="fa-regular fa-user"></i>
          <span>City</span>
        </div>

        <div class="inputBox">
          <input type="text" name="pin" required="required">
          <i class="fa-regular fa-user"></i>
          <span>Pin Code</span>
        </div>

        <div class="inputBox">
          <input type="text" name="state" required="required">
          <i class="fa-regular fa-user"></i>
          <span>State</span>
        </div>

        <div class="inputBox">
          <input type="text" name="country" required="required">
          <i class="fa-regular fa-user"></i>
          <span>Country</span>
        </div>
        

        <div class="inputBox">
          <input type="submit" value="Add Address">
        </div>
	 </form>
  
	
  
    </div>
  </section>

<script src="login.js"></script>

</body>
</html>
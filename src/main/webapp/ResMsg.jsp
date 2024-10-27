<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thankyou</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>
    
    <%@include file="nav.jsp" %>
    
    <section class="menu" id="menu">
	
        <div class="box-container" style="margin-top:40px;">
 			<%
 			String msg = (String)request.getAttribute("msg");
 			%>
            <div class="box">
                <h3><%=msg%></h3>
            </div>
        </div>
    </section>
  

    <script src="style.js"></script>
    
    
</body>
</html>
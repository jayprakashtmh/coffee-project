<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>
    
    <%@include file="nav.jsp"%>
    
    <section class="contact" id="contact">
        <h1 class="heading"><span>contact</span> us</h1>
        <div class="row">

            <iframe class="map" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3597.534949663017!2d85.1302980154419!3d25.620365220688022!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x39ed58476726506f%3A0x3d1d731db6518eb6!2sSharde%20Computer%20Institute!5e0!3m2!1sen!2sin!4v1660808328874!5m2!1sen!2sin" ></iframe>

            <form action="sajida" method="post">
                <h3>get in touch</h3>
                <div class="inputBox">
                    <span class="fas fa-user"></span>
                    <input type="text" name="name" placeholder="name">
                </div>
                <div class="inputBox">
                    <span class="fas fa-envelope"></span>
                    <input type="email" name="email" placeholder="email">
                </div>
                <div class="inputBox">
                    <span class="fas fa-phone"></span>
                    <input type="number" name="phno" placeholder="number">
                </div>
                <input type="submit" value="contact now" class="btn" onclick="printPopUp()">
            </form>
            
        </div>
    </section>
    <script type="text/javascript">
    <%
    String str = (String)request.getAttribute("msg");
    if(str!=null){
    	out.print(str);
    %>
    function printPopUp() { 
        alert("Pop-up dialog-box");
        window.print(); 
    } 
    <%}%>
    </script>

    <script src="style.js"></script>
</body>
</html>
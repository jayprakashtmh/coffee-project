<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="jay.ui.user.address.Address, java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Address</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>

	<%@include file="nav.jsp"%>
    
    <section class="blogs" id="blogs">
        <h1 class="heading">address</h1>
        <div class="box-container">
            
            <%
            @SuppressWarnings("unchecked")
            ArrayList<Address> ala = (ArrayList<Address>) session.getAttribute("address");
            Iterator<Address> it = ala.iterator();
            while(it.hasNext()){
            	Address a = it.next();
            %>
            <div class="box">
                <div class="content">
                    <p><%=a.getDoorNo()%>,<%=a.getStreet()%>,<%=a.getCity()%>,<%=a.getPin()%>,<%=a.getState()%>,<%=a.getCountry()%></p>
                    <a href="deladd?aid=<%=a.getId()%>" class="btn">delete</a>
                </div>
            </div>
           <%} %>
            
        </div>
        <a href="addaddress?cid=<%=u.getId()%>" class="btn">Add Address</a>
    </section>

	<script src="style.js"></script>

</body>
</html>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="jay.admin.content.menu.Menu, java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>
    
    <%@include file="nav.jsp" %>
    
    <section class="menu" id="menu">
        <h1 class="heading">our <span>menu</span></h1>

        <div class="box-container">
        
        <%
        @SuppressWarnings("unchecked")
        ArrayList<Menu> alm = (ArrayList<Menu>)request.getAttribute("menu");
        Iterator<Menu> it = alm.iterator();
        while(it.hasNext()){
        	Menu m = it.next();
        	String path = "./menu_img/" + m.getPic_url();
        	double dp = m.getPrice();
        	dp*=0.1;
        %>
            <div class="box">
                <img src="<%=path%>" alt="">
                <h3><%=m.getName()%></h3>
                <div class="price">&#8377;<%=m.getPrice()-dp%> <span>&#8377;<%=m.getPrice()%></span></div>
                
                <%
                if(u!=null){
                %>
                <a href="plceord?pid=<%=m.getId()%>&type=menu" class="btn">Add to Cart</a>
                <%}else{ %>
                <a href="LoginUser.jsp" class="btn">Login</a>
                <%} %>
            </div>
         <%} %>
        </div>
    </section>

    <script src="style.js"></script>
</body>
</html>
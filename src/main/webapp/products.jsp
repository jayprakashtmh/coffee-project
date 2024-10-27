<%@page import="java.util.Iterator"%>
<%@page import="jakarta.servlet.annotation.WebServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="jay.admin.content.product.Product, java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Products</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>
    
    <%@include file="nav.jsp" %>
    
    <section class="products">
        <h1 class="heading">our <span>Products</span></h1>

        <div class="box-container">
		
		<%
		@SuppressWarnings("unchecked")
		ArrayList<Product> alp = (ArrayList<Product>)request.getAttribute("product");
		Iterator<Product> it = alp.iterator();
		while(it.hasNext()){
			Product p = it.next();
			String path = "./product_img/" + p.getPic_url();
		%>
		
            <div class="box">
                <div class="icons">
	                <%
	                if(u!=null){
	                %>
                    <a href="plceord?pid=<%=p.getId()%>&type=prod" class="fas fa-shopping-cart"></a>
                    <%}else{ %>
                    <a href="LoginUser.jsp" class="fas fa-lock"></a>
                    <%} %>
                    <a href="#" class="fas fa-heart"></a>
                    <a href="#" class="fas fa-eye"></a>
                </div>
                <div class="image">
                    <img src=<%=path%> alt="">
                </div>
                <div class="content">
                    <h3><%=p.getName()%></h3>
                    <div class="stars">
                    <%
                    	for(int i=1; i<=5; i++){
                    		if(i<=p.getRating()){
                    			%>
                    			<i class="fas fa-star"></i>
                    			<%
                    		}else{
                    			%>
                    			<i class="far fa-star"></i>
                    			<%
                    		}
                    		
                    	}
                    %>
                    </div>
                    <div class="price">&#8377;<%=p.getPrice()-p.getPrice()*0.1%> <span>&#8377;<%=p.getPrice()%></span></div>
                </div>
            </div>
           <%} %>
        </div>
    </section>

    <script src="style.js"></script>
</body>
</html>
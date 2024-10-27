<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="jay.ui.order.Order, java.util.*,jay.ui.user.address.Address"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>
    
    <%@include file="nav.jsp" %>
    
    <section class="menu" id="menu">
        <h1 class="heading">Your <span>Order</span></h1>

        <div class="box-container">
        
        <%
        @SuppressWarnings("unchecked")
        ArrayList<Order> ord = (ArrayList<Order>)request.getAttribute("order");
        Iterator<Order> it = ord.iterator();
        
        @SuppressWarnings("unchecked")
        ArrayList<Address> add = (ArrayList<Address>)session.getAttribute("address");
        
        while(it.hasNext()){
        	Order o = it.next();
        	String path=null;
        	if(o.getOrdType().equals("menu"))
        		path = "./menu_img/" + o.getProdPicUrl();
        	else
        		path = "./product_img/"+o.getProdPicUrl();
        	Address a = new Address();
        	Iterator<Address> ita = add.iterator();
        	while(ita.hasNext()){
        		Address e = ita.next();
        		if(e.getId()==o.getAddId()){
        			a=e;
        			break;
        		}
        	}
        %>
            <div class="box">
                <img src="<%=path%>" alt="">
                <h3><%=o.getProdName()%></h3>
                <div class="price">&#8377;<%=o.getProdPrice()%></div>
                <div class="price">Quantity : <%=o.getProdQty()%></div>
                <div class="price">Total Price : &#8377;<%=o.getProdQty()*o.getProdPrice()%></div>
                <div class="price">Address : <%=a.getDoorNo()%>, <%=a.getStreet()%>, <%=a.getPin()%></div>
            </div>
         <%} %>
        </div>
    </section>

    <script src="style.js"></script>
</body>
</html>
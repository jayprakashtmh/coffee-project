<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="jay.ui.user.User"%>
<header class="header">
        <a href="index.jsp" class="logo">
            <img src="img/LOGO.png" alt="">
        </a>

        <nav class="navbar">
            <a href="index.jsp">Home</a>
            <a href="viewui">About</a>
            <a href="menuui">Menu</a>
            <a href="productsui">Products</a>
            <a href="review.jsp">Review</a>
            <a href="contact.jsp">Contact</a>
            <a href="blogsui">Blogs</a>
        </nav>
		<%
		User u = (User)session.getAttribute("user");
		boolean b = false;
		if(u!=null){
			b=true;
		}
		%>
        <div class="icons">
        	<%
        	if(!b){
        	%>
        	<a href="LoginUser.jsp">
            	<i class="fas fa-user"></i>
            </a>
            <%}else{
    			String path = "./img/"+u.getPic();
            %>
            <div class="fas" id="user-btn"><img src=<%=path%>></div>
            <%} %>
            <div class="fas fa-bars" id="menu-btn"></div>
        </div>

		<%
		if(b){
			String path = "./img/"+u.getPic();
		%>
        <div class="container">

            <div class="user">
                <img src=<%=path%> alt="" width="150px">
                <div class="content">
                    <h3><%=u.getName()%></h3>
                </div>
            </div>

            <a href="order" class="btn">Orders</a>
            <a href="editprofile" class="btn">Edit Profile</a>
            <a href="viewaddress" class="btn">Saved Address</a>
            <a href="logoutuser" class="btn">Logout</a>
        </div>
        <%} %>
    </header>